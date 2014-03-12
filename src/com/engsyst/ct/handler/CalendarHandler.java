package com.engsyst.ct.handler;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.CalendarContract.Calendars;
import android.provider.CalendarContract.Events;

/**
 * Represent existing calendars and their events
 * @author engsyst
 *
 */
public class CalendarHandler {

	public static final String[] EVENT_PROJECTION = new String[] {
			Calendars._ID, // 0
			Calendars.ACCOUNT_NAME, // 1
			Calendars.CALENDAR_DISPLAY_NAME, // 2
			Calendars.OWNER_ACCOUNT // 3
	};

	/**
	 * Represent existing calendars
	 */
	private com.engsyst.ct.entity.Calendar[] cs;
	private com.engsyst.ct.entity.Event[] events;

	private Context context;

	public CalendarHandler(Context context) {
		this.context = context;
		cs = getCalendars();
	}

	/**
	 * @return titles of existing calendars
	 */
	public String[] getCalendarsTitles() {
		if (cs == null)
			return null;
		String[] s = new String[cs.length];
		for (int i = 0; i < cs.length; i++)
			s[i] = cs[i].getCalendarDisplayname();
		return s;
	}

	public com.engsyst.ct.entity.Calendar[] getCalendars() {
		// Prepare query
		ContentResolver cr = context.getContentResolver();
		Uri uri = Calendars.CONTENT_URI;

		// Submit the query and get a Cursor object back.
		Cursor cur = cr.query(uri, null, null, null, null);

		// Use the cursor to step through the returned records
		if (cur.getCount() == 0)
			return null;
		cs = new com.engsyst.ct.entity.Calendar[cur.getCount()];
		int i = 0;
		while (cur.moveToNext()) {
			com.engsyst.ct.entity.Calendar cal = new com.engsyst.ct.entity.Calendar();
			// Get the field values
			try {
				cal.setId(cur.getLong(cur.getColumnIndex(Calendars._ID)));
				cal.setAccountName(cur.getString(cur.getColumnIndex(Calendars.ACCOUNT_NAME)));
				cal.setAccountType(cur.getString(cur.getColumnIndex(Calendars.ACCOUNT_TYPE)));
				cal.setSyncId(cur.getString(cur.getColumnIndex(Calendars._SYNC_ID)));
				cal.setDirty(cur.getLong(cur.getColumnIndex(Calendars.DIRTY)));
				cal.setName(cur.getString(cur.getColumnIndex(Calendars.NAME)));
				cal.setCalendarDisplayname(cur.getString(cur.getColumnIndex(Calendars.CALENDAR_DISPLAY_NAME)));
				cal.setCalendarColor(cur.getInt(cur.getColumnIndex(Calendars.CALENDAR_COLOR)));
				cal.setCalendarColorKey(cur.getString(cur.getColumnIndex(Calendars.CALENDAR_COLOR_KEY)));
				cal.setCalendarAccessLevel(cur.getInt(cur.getColumnIndex(Calendars.CALENDAR_ACCESS_LEVEL)));
				cal.setVisible(cur.getInt(cur.getColumnIndex(Calendars.VISIBLE)));
				cal.setSyncEvents(cur.getInt(cur.getColumnIndex(Calendars.SYNC_EVENTS)));
				cal.setCalendarLocation(cur.getString(cur.getColumnIndex(Calendars.CALENDAR_LOCATION)));
				cal.setCalendarTimezone(cur.getString(cur.getColumnIndex(Calendars.CALENDAR_TIME_ZONE)));
				cal.setOwnerAccount(cur.getString(cur.getColumnIndex(Calendars.OWNER_ACCOUNT)));
				cal.setCanOrganizerRespond(cur.getInt(cur.getColumnIndex(Calendars.CAN_ORGANIZER_RESPOND)));
				cal.setCanModifyTimezone(cur.getInt(cur.getColumnIndex(Calendars.CAN_MODIFY_TIME_ZONE)));
				cal.setCanPartiallyUpdate(cur.getInt(cur.getColumnIndex(Calendars.CAN_PARTIALLY_UPDATE)));
				cal.setMaxReminders(cur.getInt(cur.getColumnIndex(Calendars.MAX_REMINDERS)));
				cal.setAllowedReminders(cur.getString(cur.getColumnIndex(Calendars.ALLOWED_REMINDERS)));
				cal.setAllowedAvailability(cur.getString(cur.getColumnIndex(Calendars.ALLOWED_AVAILABILITY)));
				cal.setAllowedAttendeeTypes(cur.getString(cur.getColumnIndex(Calendars.ALLOWED_ATTENDEE_TYPES)));
				cal.setDeleted(cur.getInt(cur.getColumnIndex(Calendars.DELETED)));
			} catch (Exception e) {
				e.getMessage();
			}
			cs[i] = cal;
			i++;
		}
		cur.close();
		return cs;
	}

	public com.engsyst.ct.entity.Event[] getEvents() {
		// Prepare query
		ContentResolver cr = context.getContentResolver();
		Uri uri = Events.CONTENT_URI;
		
		// Submit the query and get a Cursor object back.
		Cursor cur = cr.query(uri, null, null, null, null);

//		String[] titles = getTableTitles(cur); 
//		String s = Arrays.toString(titles);
		
		// Use the cursor to step through the returned records
		if (cur.getCount() == 0)
			return null;
		events = new com.engsyst.ct.entity.Event[cur.getCount()];
//		int i = 0;
//		while (cur.moveToNext()) {
//			com.engsyst.ct.entity.Event event = new com.engsyst.ct.entity.Event();
//			// Get the field values
//			try {
//				event.setId(cur.getLong(cur.getColumnIndex(Events._ID)));
//				event.setAccountName(cur.getString(cur.getColumnIndex(Events.NAME)));
//				event.setAccountType(cur.getString(cur.getColumnIndex(Events.ACCOUNT_TYPE)));
//				event.setSyncId(cur.getString(cur.getColumnIndex(Events._SYNC_ID)));
//				event.setDirty(cur.getLong(cur.getColumnIndex(Events.DIRTY)));
//				event.setName(cur.getString(cur.getColumnIndex(Events.TITLE)));
//				event.setCalendarDisplayname(cur.getString(cur.getColumnIndex(Events.CALENDAR_DISPLAY_NAME)));
//				event.setCalendarColor(cur.getInt(cur.getColumnIndex(Events.CALENDAR_COLOR)));
//				event.setCalendarColorKey(cur.getString(cur.getColumnIndex(Events.CALENDAR_COLOR_KEY)));
//				event.setCalendarAccessLevel(cur.getInt(cur.getColumnIndex(Events.CALENDAR_ACCESS_LEVEL)));
//				event.setVisible(cur.getInt(cur.getColumnIndex(Events.VISIBLE)));
//				event.setSyncEvents(cur.getInt(cur.getColumnIndex(Events.SYNC_EVENTS)));
//				event.setCalendarLocation(cur.getString(cur.getColumnIndex(Events.CALENDAR_LOCATION)));
//				event.setCalendarTimezone(cur.getString(cur.getColumnIndex(Events.CALENDAR_TIME_ZONE)));
//				event.setOwnerAccount(cur.getString(cur.getColumnIndex(Events.OWNER_ACCOUNT)));
//				event.setCanOrganizerRespond(cur.getInt(cur.getColumnIndex(Events.CAN_ORGANIZER_RESPOND)));
//				event.setCanModifyTimezone(cur.getInt(cur.getColumnIndex(Events.CAN_MODIFY_TIME_ZONE)));
//				event.setCanPartiallyUpdate(cur.getInt(cur.getColumnIndex(Events.CAN_PARTIALLY_UPDATE)));
//				event.setMaxReminders(cur.getInt(cur.getColumnIndex(Events.MAX_REMINDERS)));
//				event.setAllowedReminders(cur.getString(cur.getColumnIndex(Events.ALLOWED_REMINDERS)));
//				event.setAllowedAvailability(cur.getString(cur.getColumnIndex(Events.ALLOWED_AVAILABILITY)));
//				event.setAllowedAttendeeTypes(cur.getString(cur.getColumnIndex(Events.ALLOWED_ATTENDEE_TYPES)));
//				event.setDeleted(cur.getInt(cur.getColumnIndex(Events.DELETED)));
//			} catch (Exception e) {
//				Log.e(null, e.getMessage(), e);
//			}
//			cs[i] = cal;
//			i++;
//		}
		cur.close();
		return events;
	}
	
	private String[] getTableTitles(Cursor cur) {
		return cur.getColumnNames();
	}
}
