package com.test.schemas;

/**
 * Created by syerrami on 10/14/15.
 */

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("com.googlecode.jsonschema2pojo")
@JsonPropertyOrder({
        "accountNumber",
        "transAmount",
        "cardMemberName",
        "product"
})
public class Event {

    @JsonProperty("accountNumber")
    private String accountNumber;

    @JsonProperty("transAmount")
    private String transAmount;

    @JsonProperty("cardMemberName")
    private String cardMemberName;

    @JsonProperty("product")
    private String product;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public boolean equals(Object other) {
        return EqualsBuilder.reflectionEquals(this, other);
    }

}
