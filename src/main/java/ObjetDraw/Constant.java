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
        Small {
            @Override
            public String toString() {
                return "small";
            }
        },
        Medium {
            @Override
            public String toString() {
                return "Medium";
            }
        },
        Large {
            @Override
            public String toString() {
                return "Large";
            }
        }
    }
}
