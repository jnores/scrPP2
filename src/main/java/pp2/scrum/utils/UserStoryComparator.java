package pp2.scrum.utils;

import java.util.Comparator;

import pp2.scrum.model.UserStory;

/**
 * @author yoshknight
 *
 */
public enum UserStoryComparator implements Comparator<UserStory> {
    NUMERO_SORT {
        @Override
        public int compare(UserStory o1, UserStory o2) {
            return Long.valueOf(o1.getId()).compareTo(o2.getId());
        }

        @Override
        public String toString() {
            return "Número";
        }
    },
    TITULO_SORT {
        @Override
        public int compare(UserStory o1, UserStory o2) {
            return o1.getTitulo().compareTo(o2.getTitulo());
        }

        @Override
        public String toString() {
            return "Título";
        }
    };
    
    public static Comparator<UserStory> decending(final Comparator<UserStory> other) {
        return new Comparator<UserStory>() {
            public int compare(UserStory o1, UserStory o2) {
                return -1 * other.compare(o1, o2);
            }
        };
    }

    public static Comparator<UserStory> getComparator(final UserStoryComparator... multipleOptions) {
        return new Comparator<UserStory>() {
            public int compare(UserStory o1, UserStory o2) {
                for (UserStoryComparator option : multipleOptions) {
                    int result = option.compare(o1, o2);
                    if (result != 0) {
                        return result;
                    }
                }
                return 0;
            }
        };
    }

}
