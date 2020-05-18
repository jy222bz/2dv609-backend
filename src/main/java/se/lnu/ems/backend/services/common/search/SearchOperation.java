package se.lnu.ems.backend.services.common.search;

/**
 * The enum Search operation.
 */
public enum SearchOperation {
    /**
     * Greater than search operation.
     */
    GREATER_THAN,
    /**
     * Less than search operation.
     */
    LESS_THAN,
    /**
     * Greater than equal search operation.
     */
    GREATER_THAN_EQUAL,
    /**
     * Less than equal search operation.
     */
    LESS_THAN_EQUAL,
    /**
     * Not equal search operation.
     */
    NOT_EQUAL,
    /**
     * Equal search operation.
     */
    EQUAL,
    /**
     * Match search operation.
     */
    MATCH,
    /**
     * Match start search operation.
     */
    MATCH_START,
    /**
     * Match end search operation.
     */
    MATCH_END,
    /**
     * In search operation.
     */
    IN,
    /**
     * Not in search operation.
     */
    NOT_IN
}
