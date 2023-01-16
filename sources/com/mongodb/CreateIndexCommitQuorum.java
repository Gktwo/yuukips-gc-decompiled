package com.mongodb;

import com.mongodb.assertions.Assertions;
import org.bson.BsonInt32;
import org.bson.BsonString;
import org.bson.BsonValue;

/* loaded from: grasscutter.jar:com/mongodb/CreateIndexCommitQuorum.class */
public abstract class CreateIndexCommitQuorum {
    public static final CreateIndexCommitQuorum MAJORITY = new CreateIndexCommitQuorumWithMode("majority");
    public static final CreateIndexCommitQuorum VOTING_MEMBERS = new CreateIndexCommitQuorumWithMode("votingMembers");

    public abstract BsonValue toBsonValue();

    public static CreateIndexCommitQuorum create(String mode) {
        return new CreateIndexCommitQuorumWithMode(mode);
    }

    public static CreateIndexCommitQuorum create(int w) {
        return new CreateIndexCommitQuorumWithW(w);
    }

    private CreateIndexCommitQuorum() {
    }

    /* loaded from: grasscutter.jar:com/mongodb/CreateIndexCommitQuorum$CreateIndexCommitQuorumWithMode.class */
    private static final class CreateIndexCommitQuorumWithMode extends CreateIndexCommitQuorum {
        private final String mode;

        private CreateIndexCommitQuorumWithMode(String mode) {
            super();
            Assertions.notNull("mode", mode);
            this.mode = mode;
        }

        public String getMode() {
            return this.mode;
        }

        @Override // com.mongodb.CreateIndexCommitQuorum
        public BsonValue toBsonValue() {
            return new BsonString(this.mode);
        }

        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            return this.mode.equals(((CreateIndexCommitQuorumWithMode) o).mode);
        }

        public int hashCode() {
            return this.mode.hashCode();
        }

        public String toString() {
            return "CreateIndexCommitQuorum{mode=" + this.mode + '}';
        }
    }

    /* loaded from: grasscutter.jar:com/mongodb/CreateIndexCommitQuorum$CreateIndexCommitQuorumWithW.class */
    private static final class CreateIndexCommitQuorumWithW extends CreateIndexCommitQuorum {

        /* renamed from: w */
        private final int f426w;

        private CreateIndexCommitQuorumWithW(int w) {
            super();
            if (w < 0) {
                throw new IllegalArgumentException("w cannot be less than zero");
            }
            this.f426w = w;
        }

        public int getW() {
            return this.f426w;
        }

        @Override // com.mongodb.CreateIndexCommitQuorum
        public BsonValue toBsonValue() {
            return new BsonInt32(this.f426w);
        }

        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            return o != null && getClass() == o.getClass() && this.f426w == ((CreateIndexCommitQuorumWithW) o).f426w;
        }

        public int hashCode() {
            return this.f426w;
        }

        public String toString() {
            return "CreateIndexCommitQuorum{w=" + this.f426w + '}';
        }
    }
}
