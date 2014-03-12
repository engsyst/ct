package com.engsyst.ct.entity;


public class Calendar {
	private long id;
	private String accountName;
	private String accountType;
	private String syncId;
	private long dirty;
	private String name;
	private String calendarDisplayname;
	private int calendarColor;
	private String calendarColorKey;
	private int calendarAccessLevel;
	private int visible; // boolean
	private int syncEvents; // boolean
	private String calendarLocation;
	private String calendarTimezone;
	private String ownerAccount;
	private int canOrganizerRespond; // boolean
	private int canModifyTimezone; // boolean
	private int canPartiallyUpdate; // boolean
	private int maxReminders;
	/**
	 * A comma separated list of availability types supported for this calendar
	 * in the format "#,#,#". Valid types are AVAILABILITY_BUSY,
	 * AVAILABILITY_FREE, AVAILABILITY_TENTATIVE. Setting this field to only
	 * AVAILABILITY_BUSY should be used to indicate that changing the
	 * availability is not supported.
	 */
	private String allowedReminders;
	/**
	 * A comma separated list of reminder methods supported for this calendar in
	 * the format "#,#,#". Valid types are METHOD_DEFAULT, METHOD_ALERT,
	 * METHOD_EMAIL, METHOD_SMS, METHOD_ALARM. Column name.
	 */
	private String allowedAvailability;
	/**
	 * A comma separated list of attendee types supported for this calendar in
	 * the format "#,#,#". Valid types are TYPE_NONE, TYPE_OPTIONAL,
	 * TYPE_REQUIRED, TYPE_RESOURCE. Setting this field to only TYPE_NONE should
	 * be used to indicate that changing the attendee type is not supported.
	 */
	private String allowedAttendeeTypes;
	private int deleted; // boolean
	private String calSync1;
	private String calSync2;
	private String calSync3;
	private String calSync4;
	private String calSync5;
	private String calSync6;
	private String calSync7;
	private String calSync8;
	private String calSync9;
	private String calSync10;
	
	public long getId() {
		return id;
	}
	public String getAccountName() {
		return accountName;
	}
	public String getAccountType() {
		return accountType;
	}
	public String getSyncId() {
		return syncId;
	}
	public long getDirty() {
		return dirty;
	}
	public String getName() {
		return name;
	}
	public String getCalendarDisplayname() {
		return calendarDisplayname;
	}
	public int getCalendarColor() {
		return calendarColor;
	}
	public String getCalendarColorKey() {
		return calendarColorKey;
	}
	public int getCalendarAccessLevel() {
		return calendarAccessLevel;
	}
	public int getVisible() {
		return visible;
	}
	public int getSyncEvents() {
		return syncEvents;
	}
	public String getCalendarLocation() {
		return calendarLocation;
	}
	public String getCalendarTimezone() {
		return calendarTimezone;
	}
	public String getOwnerAccount() {
		return ownerAccount;
	}
	public int getCanOrganizerRespond() {
		return canOrganizerRespond;
	}
	public int getCanModifyTimezone() {
		return canModifyTimezone;
	}
	public int getCanPartiallyUpdate() {
		return canPartiallyUpdate;
	}
	public int getMaxReminders() {
		return maxReminders;
	}
	public String getAllowedReminders() {
		return allowedReminders;
	}
	public String getAllowedAvailability() {
		return allowedAvailability;
	}
	public String getAllowedAttendeeTypes() {
		return allowedAttendeeTypes;
	}
	public int getDeleted() {
		return deleted;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public void setSyncId(String syncId) {
		this.syncId = syncId;
	}
	public void setDirty(long dirty) {
		this.dirty = dirty;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setCalendarDisplayname(String calendarDisplayname) {
		this.calendarDisplayname = calendarDisplayname;
	}
	public void setCalendarColor(int calendarColor) {
		this.calendarColor = calendarColor;
	}
	public void setCalendarColorKey(String calendarColorIndex) {
		this.calendarColorKey = calendarColorIndex;
	}
	public void setCalendarAccessLevel(int calendarAccessLevel) {
		this.calendarAccessLevel = calendarAccessLevel;
	}
	public void setVisible(int visible) {
		this.visible = visible;
	}
	public void setSyncEvents(int syncEvents) {
		this.syncEvents = syncEvents;
	}
	public void setCalendarLocation(String calendarLocation) {
		this.calendarLocation = calendarLocation;
	}
	public void setCalendarTimezone(String calendarTimezone) {
		this.calendarTimezone = calendarTimezone;
	}
	public void setOwnerAccount(String ownerAccount) {
		this.ownerAccount = ownerAccount;
	}
	public void setCanOrganizerRespond(int canOrganizerRespond) {
		this.canOrganizerRespond = canOrganizerRespond;
	}
	public void setCanModifyTimezone(int canModifyTimezone) {
		this.canModifyTimezone = canModifyTimezone;
	}
	public void setCanPartiallyUpdate(int canPartiallyUpdate) {
		this.canPartiallyUpdate = canPartiallyUpdate;
	}
	public void setMaxReminders(int maxReminders) {
		this.maxReminders = maxReminders;
	}
	public void setAllowedReminders(String allowedReminders) {
		this.allowedReminders = allowedReminders;
	}
	public void setAllowedAvailability(String allowedAvailability) {
		this.allowedAvailability = allowedAvailability;
	}
	public void setAllowedAttendeeTypes(String allowedAttendeeTypes) {
		this.allowedAttendeeTypes = allowedAttendeeTypes;
	}
	public void setDeleted(int deleted) {
		this.deleted = deleted;
	}
	

}
