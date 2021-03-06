/** Generated by the default template from graphql-java-generator */
package com.graphql_java_generator.client.domain.allGraphQLCases;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.graphql_java_generator.GraphQLField;
import com.graphql_java_generator.annotation.GraphQLInputParameters;
import com.graphql_java_generator.annotation.GraphQLNonScalar;
import com.graphql_java_generator.annotation.GraphQLObjectType;
import com.graphql_java_generator.annotation.GraphQLScalar;
import java.util.List;

/**
 * @author generated by graphql-java-generator
 * @see <a href="https://github.com/graphql-java-generator/graphql-java-generator">https://github.com/graphql-java-generator/graphql-java-generator</a>
 */
@GraphQLObjectType("__Type")
public class __Type  {

	public __Type(){
		// No action
	}

	@JsonProperty("kind")
	@GraphQLScalar(fieldName = "kind", graphQLTypeName = "__TypeKind", javaClass = __TypeKind.class)
	__TypeKind kind;


	@JsonProperty("name")
	@GraphQLScalar(fieldName = "name", graphQLTypeName = "String", javaClass = String.class)
	String name;


	@JsonProperty("description")
	@GraphQLScalar(fieldName = "description", graphQLTypeName = "String", javaClass = String.class)
	String description;


	@JsonDeserialize(contentAs = __Field.class)
	@GraphQLInputParameters(names = {"includeDeprecated"}, types = {"Boolean"})
	@JsonProperty("fields")
	@GraphQLNonScalar(fieldName = "fields", graphQLTypeName = "__Field", javaClass = __Field.class)
	List<__Field> fields;


	@JsonDeserialize(contentAs = __Type.class)
	@JsonProperty("interfaces")
	@GraphQLNonScalar(fieldName = "interfaces", graphQLTypeName = "__Type", javaClass = __Type.class)
	List<__Type> interfaces;


	@JsonDeserialize(contentAs = __Type.class)
	@JsonProperty("possibleTypes")
	@GraphQLNonScalar(fieldName = "possibleTypes", graphQLTypeName = "__Type", javaClass = __Type.class)
	List<__Type> possibleTypes;


	@JsonDeserialize(contentAs = __EnumValue.class)
	@GraphQLInputParameters(names = {"includeDeprecated"}, types = {"Boolean"})
	@JsonProperty("enumValues")
	@GraphQLNonScalar(fieldName = "enumValues", graphQLTypeName = "__EnumValue", javaClass = __EnumValue.class)
	List<__EnumValue> enumValues;


	@JsonDeserialize(contentAs = __InputValue.class)
	@JsonProperty("inputFields")
	@GraphQLNonScalar(fieldName = "inputFields", graphQLTypeName = "__InputValue", javaClass = __InputValue.class)
	List<__InputValue> inputFields;


	@JsonProperty("ofType")
	@GraphQLNonScalar(fieldName = "ofType", graphQLTypeName = "__Type", javaClass = __Type.class)
	__Type ofType;


	@JsonProperty("__typename")
	@GraphQLScalar(fieldName = "__typename", graphQLTypeName = "String", javaClass = String.class)
	String __typename;



	public void setKind(__TypeKind kind) {
		this.kind = kind;
	}

	public __TypeKind getKind() {
		return kind;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setFields(List<__Field> fields) {
		this.fields = fields;
	}

	public List<__Field> getFields() {
		return fields;
	}

	public void setInterfaces(List<__Type> interfaces) {
		this.interfaces = interfaces;
	}

	public List<__Type> getInterfaces() {
		return interfaces;
	}

	public void setPossibleTypes(List<__Type> possibleTypes) {
		this.possibleTypes = possibleTypes;
	}

	public List<__Type> getPossibleTypes() {
		return possibleTypes;
	}

	public void setEnumValues(List<__EnumValue> enumValues) {
		this.enumValues = enumValues;
	}

	public List<__EnumValue> getEnumValues() {
		return enumValues;
	}

	public void setInputFields(List<__InputValue> inputFields) {
		this.inputFields = inputFields;
	}

	public List<__InputValue> getInputFields() {
		return inputFields;
	}

	public void setOfType(__Type ofType) {
		this.ofType = ofType;
	}

	public __Type getOfType() {
		return ofType;
	}

	public void set__typename(String __typename) {
		this.__typename = __typename;
	}

	public String get__typename() {
		return __typename;
	}

    public String toString() {
        return "__Type {"
				+ "kind: " + kind
				+ ", "
				+ "name: " + name
				+ ", "
				+ "description: " + description
				+ ", "
				+ "fields: " + fields
				+ ", "
				+ "interfaces: " + interfaces
				+ ", "
				+ "possibleTypes: " + possibleTypes
				+ ", "
				+ "enumValues: " + enumValues
				+ ", "
				+ "inputFields: " + inputFields
				+ ", "
				+ "ofType: " + ofType
				+ ", "
				+ "__typename: " + __typename
        		+ "}";
    }

    /**
	 * Enum of field names
	 */
	 public static enum Field implements GraphQLField {
		Kind("kind"),
		Name("name"),
		Description("description"),
		Fields("fields"),
		Interfaces("interfaces"),
		PossibleTypes("possibleTypes"),
		EnumValues("enumValues"),
		InputFields("inputFields"),
		OfType("ofType"),
		__typename("__typename");

		private String fieldName;

		Field(String fieldName) {
			this.fieldName = fieldName;
		}

		public String getFieldName() {
			return fieldName;
		}

		public Class<?> getGraphQLType() {
			return this.getClass().getDeclaringClass();
		}

	}

	public static Builder builder() {
			return new Builder();
		}



	/**
	 * Builder
	 */
	public static class Builder {
		private __TypeKind kind;
		private String name;
		private String description;
		private List<__Field> fields;
		private List<__Type> interfaces;
		private List<__Type> possibleTypes;
		private List<__EnumValue> enumValues;
		private List<__InputValue> inputFields;
		private __Type ofType;


		public Builder withKind(__TypeKind kind) {
			this.kind = kind;
			return this;
		}
		public Builder withName(String name) {
			this.name = name;
			return this;
		}
		public Builder withDescription(String description) {
			this.description = description;
			return this;
		}
		public Builder withFields(List<__Field> fields) {
			this.fields = fields;
			return this;
		}
		public Builder withInterfaces(List<__Type> interfaces) {
			this.interfaces = interfaces;
			return this;
		}
		public Builder withPossibleTypes(List<__Type> possibleTypes) {
			this.possibleTypes = possibleTypes;
			return this;
		}
		public Builder withEnumValues(List<__EnumValue> enumValues) {
			this.enumValues = enumValues;
			return this;
		}
		public Builder withInputFields(List<__InputValue> inputFields) {
			this.inputFields = inputFields;
			return this;
		}
		public Builder withOfType(__Type ofType) {
			this.ofType = ofType;
			return this;
		}

		public __Type build() {
			__Type _object = new __Type();
			_object.setKind(kind);
			_object.setName(name);
			_object.setDescription(description);
			_object.setFields(fields);
			_object.setInterfaces(interfaces);
			_object.setPossibleTypes(possibleTypes);
			_object.setEnumValues(enumValues);
			_object.setInputFields(inputFields);
			_object.setOfType(ofType);
			_object.set__typename("__Type");
			return _object;
		}
	}
}
