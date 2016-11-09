package ObjetDraw;

/**
 * Created by cuongnb on 11/8/16.
 */
public class Constant {
    public enum Level {
        NoAns {
            @Override
            public String toString() {
                return "NoAns";
            }
        },
        SoftEvident {
            @Override
            public String toString() {
                return "SoftEvident";
            }
        },
        small {
            @Override
            public String toString() {
                return "small";
            }
        },
        medium {
            @Override
            public String toString() {
                return "medium";
            }
        },
        large {
            @Override
            public String toString() {
                return "large";
            }
        }
    }
}
