package org.geneontology.obographs.model.axiom;

import java.util.List;
import java.util.Set;

import org.geneontology.obographs.model.Meta;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Corresponds to an axiom of the form C = X1 and ... and Xn,
 * Where X_i is either a named class or OWL Restriction
 * 
 * 
 * @author cjm
 *
 */
public class LogicalDefinitionAxiom extends AbstractAxiom {

    private LogicalDefinitionAxiom(Builder builder) {
        super(builder);
        definedClassId = builder.definedClassId;
        genusIds = builder.genusIds;
        restrictions = builder.restrictions;
    }

    private final String definedClassId;
    private final List<String> genusIds;
    private final List<ExistentialRestrictionExpression> restrictions;



    /**
     * @return the representativeNodeId
     */
    public String getDefinedClassId() {
        return definedClassId;
    }



    /**
     * @return the nodeIds
     */
    public List<String> getGenusIds() {
        return genusIds;
    }



    /**
     * @return the restrictions
     */
    public List<ExistentialRestrictionExpression> getRestrictions() {
        return restrictions;
    }


    public static class Builder extends AbstractAxiom.Builder {

        @JsonProperty
        private String definedClassId;
        @JsonProperty
        private List<String> genusIds;
        @JsonProperty
        private List<ExistentialRestrictionExpression> restrictions;
        @JsonProperty
        private Meta meta;

        public Builder definedClassId(String definedClassId) {
            this.definedClassId = definedClassId;
            return this;
        }

        public Builder genusIds(List<String> genusIds) {
            this.genusIds = genusIds;
            return this;
        }

        public Builder restrictions(List<ExistentialRestrictionExpression> restrictions) {
            this.restrictions = restrictions;
            return this;
        }
        
        public LogicalDefinitionAxiom build() {
            return new LogicalDefinitionAxiom(this);
        }
    }


}
