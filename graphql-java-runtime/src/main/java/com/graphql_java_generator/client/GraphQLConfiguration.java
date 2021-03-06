package com.graphql_java_generator.client;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.ws.rs.client.Client;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * This class contains a GraphQL configuration for the GraphQL client. The main element of this configuration contains
 * 
 * @author etienne-sf
 */
public class GraphQLConfiguration {

	/**
	 * The {@link QueryExecutor} is responsible for the execution of the GraphQLRequest, and for parsing the server
	 * response
	 */
	final QueryExecutor executor;

	/**
	 * This constructor expects the URI of the GraphQL server. This constructor works only for http servers, not for
	 * https ones.<BR/>
	 * For example: http://my.server.com/graphql
	 * 
	 * @param graphqlEndpoint
	 *            the http URI for the GraphQL endpoint
	 */
	public GraphQLConfiguration(String graphqlEndpoint) {
		this.executor = new QueryExecutorImpl(graphqlEndpoint);
	}

	/**
	 * This constructor expects the URI of the GraphQL server. This constructor works only for https servers, not for
	 * http ones.<BR/>
	 * For example: https://my.server.com/graphql<BR/>
	 * <BR/>
	 * {@link SSLContext} and {@link HostnameVerifier} are regular Java stuff. You'll find lots of documentation on the
	 * web. The StarWars sample is based on the <A HREF=
	 * "http://www.thinkcode.se/blog/2019/01/27/a-jersey-client-supporting-https">http://www.thinkcode.se/blog/2019/01/27/a-jersey-client-supporting-https</A>
	 * blog. But this sample implements a noHostVerification, which of course, is the simplest but the safest way to go.
	 * 
	 * @param graphqlEndpoint
	 *            the https URI for the GraphQL endpoint
	 * @param sslContext
	 * @param hostnameVerifier
	 */
	public GraphQLConfiguration(String graphqlEndpoint, SSLContext sslContext, HostnameVerifier hostnameVerifier) {
		this.executor = new QueryExecutorImpl(graphqlEndpoint, sslContext, hostnameVerifier);
	}

	/**
	 * This constructor expects the URI of the GraphQL server and a configured JAX-RS client that gives the opportunity
	 * to customise the REST request<BR/>
	 * For example: http://my.server.com/graphql
	 *
	 * @param graphqlEndpoint
	 *            the http URI for the GraphQL endpoint
	 * @param client
	 *            {@link Client} javax.ws.rs.client.Client to support customization of the rest request
	 * @param objectMapper
	 *            {@link ObjectMapper} com.fasterxml.jackson.databind.ObjectMapper to support configurable mapping
	 */
	public GraphQLConfiguration(String graphqlEndpoint, Client client, ObjectMapper objectMapper) {
		this.executor = new QueryExecutorImpl(graphqlEndpoint, client, objectMapper);
	}

	/** Retrieves the {@link QueryExecutor} for this GraphQL configuration */
	public QueryExecutor getQueryExecutor() {
		return executor;
	}

}
