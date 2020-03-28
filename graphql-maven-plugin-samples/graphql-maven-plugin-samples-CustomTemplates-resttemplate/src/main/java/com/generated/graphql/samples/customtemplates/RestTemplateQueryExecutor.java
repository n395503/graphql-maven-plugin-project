package com.generated.graphql.samples.customtemplates;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.graphql_java_generator.client.QueryExecutor;
import com.graphql_java_generator.client.request.ObjectResponse;
import com.graphql_java_generator.client.response.JsonResponseWrapper;
import com.graphql_java_generator.exception.GraphQLRequestExecutionException;

/**
 * {@link QueryExecutor} implementation using Spring {@link RestTemplate} as the http client
 * Property grapql.endpoint in required in application configuraion
 * @author ggomez
 *
 */
@Component
@Qualifier("RestTemplateQueryExecutor")
public class RestTemplateQueryExecutor implements QueryExecutor {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = LoggerFactory.getLogger(RestTemplateQueryExecutor.class);
	
	@Value("${graphql.endpoint}")
	protected String graphqlEndpoint;
	
	@Autowired
	protected RestTemplate restTemplate;
	
	protected ObjectMapper objectMapper;
	
	public RestTemplateQueryExecutor() {
		this.objectMapper = new ObjectMapper();
	}

	public <T> T execute(String requestType, ObjectResponse objectResponse, Map<String, Object> parameters,
			Class<T> valueType) throws GraphQLRequestExecutionException {
		String request = null;
		try {
			// Let's build the GraphQL request, to send to the server
			request = buildRequest(requestType, objectResponse, parameters);
			logger.trace(GRAPHQL_MARKER, "Generated GraphQL request: {}", request);

			return doJsonRequestExecution(request, valueType);
		} catch (IOException e) {
			throw new GraphQLRequestExecutionException(
					"Error when executing query <" + request + ">: " + e.getMessage(), e);
		}

	}

	public <T> T execute(String graphqlQuery, Class<T> valueType) throws GraphQLRequestExecutionException, IOException {
		return doJsonRequestExecution(graphqlQuery, valueType);
	}
	
	protected <T> T doJsonRequestExecution(String jsonRequest, Class<T> valueType)
			throws IOException, GraphQLRequestExecutionException {
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<String>(jsonRequest ,headers);
		
		JsonResponseWrapper response = this.restTemplate.postForEntity(graphqlEndpoint, 
				entity, JsonResponseWrapper.class).getBody();
		
		if(logger.isInfoEnabled()) {
			logger.trace("Parsed response data: {}", objectMapper.writeValueAsString(response.data));
			logger.trace("Parsed response errors: {}", objectMapper.writeValueAsString(response.errors));			
		}
		
		if (response.errors == null || response.errors.size() == 0) {
			// No errors. Let's parse the data
			return objectMapper.treeToValue(response.data, valueType);
		} else {
			int nbErrors = 0;
			String agregatedMessage = null;
			for (com.graphql_java_generator.client.response.Error error : response.errors) {
				String msg = error.toString();
				nbErrors += 1;
				logger.error(GRAPHQL_MARKER, msg);
				if (agregatedMessage == null) {
					agregatedMessage = msg;
				} else {
					agregatedMessage += ", ";
					agregatedMessage += msg;
				}
			}
			if (nbErrors == 0) {
				throw new GraphQLRequestExecutionException("An unknown error occured");
			} else {
				throw new GraphQLRequestExecutionException(nbErrors + " errors occured: " + agregatedMessage);
			}
		}		
	}
	
	
	/**
	 * Builds a single GraphQL request from the parameter given.
	 * 
	 * @param requestType
	 *            One of "query", "mutation" or "subscription"
	 * @param objectResponse
	 *            Defines what response is expected from the server. The {@link ObjectResponse#getFieldAlias()} method
	 *            returns the field of the query, that is: the query name.
	 * @param parameters
	 * @return The GraphQL request, ready to be sent to the GraphQl server.
	 * @throws GraphQLRequestExecutionException
	 */
	String buildRequest(String requestType, ObjectResponse objectResponse, Map<String, Object> parameters)
			throws GraphQLRequestExecutionException {

		if (!requestType.equals("query") && !requestType.equals("mutation") && !requestType.equals("subscription")) {
			throw new IllegalArgumentException(
					"requestType must be one of \"query\", \"mutation\" or \"subscription\", but is \"" + requestType
							+ "\"");
		}

		StringBuilder sb = new StringBuilder();
		sb.append(requestType);
		sb.append("{");
		objectResponse.appendResponseQuery(sb, parameters, false);
		sb.append("}");

		return "{\"query\":\"" + sb.toString() + "\",\"variables\":null,\"operationName\":null}";
	}	

}
