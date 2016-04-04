package com.ungs.pp2.scrPP2.Dominio.Enums;

import java.util.Comparator;

import com.ungs.pp2.scrPP2.Controller.UserStoryHelper;

/**
 * @author yoshknight
 *
 */
public enum UserStoryHelperComparator implements Comparator<UserStoryHelper> {
	ID_SORT {
		@Override
	    public int compare(UserStoryHelper o1, UserStoryHelper o2) {
	        return Integer.valueOf(o1.getId()).compareTo(o2.getId());
	    }},
	TITLE_SORT {
	    public int compare(UserStoryHelper o1, UserStoryHelper o2) {
	        return o1.getTitulo().compareTo(o2.getTitulo());
	    }};
	
	public static Comparator<UserStoryHelper> decending(final Comparator<UserStoryHelper> other) {
	    return new Comparator<UserStoryHelper>() {
	        public int compare(UserStoryHelper o1, UserStoryHelper o2) {
	            return -1 * other.compare(o1, o2);
	        }
	    };
	}
	
	public static Comparator<UserStoryHelper> getComparator(final UserStoryHelperComparator... multipleOptions) {
	    return new Comparator<UserStoryHelper>() {
	        public int compare(UserStoryHelper o1, UserStoryHelper o2) {
	            for (UserStoryHelperComparator option : multipleOptions) {
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
