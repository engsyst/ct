package com.engsyst.ct;

import java.util.ArrayList;

import android.app.ActionBar;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.engsyst.ct.entity.Event;
import com.engsyst.ct.entity.ItemData;
import com.engsyst.ct.entity.Rnd;
import com.engsyst.ct.handler.CalendarHandler;

public class MainActivity extends FragmentActivity implements
		ActionBar.OnNavigationListener {

	/**
	 * The serialization (saved instance state) Bundle key representing the
	 * current dropdown position.
	 */
	private static final String STATE_SELECTED_NAVIGATION_ITEM = "selected_navigation_item";

	private String[] calendarTitles = null;
	private CalendarHandler calendarHandler = null;
	Context context;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		// Set up the action bar to show a dropdown list.
		final ActionBar actionBar = getActionBar();
		actionBar.setDisplayShowTitleEnabled(false);
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);

		context = getApplicationContext();
		calendarHandler = new CalendarHandler(context);
		calendarTitles = calendarHandler.getCalendarsTitles();
		if (calendarTitles == null)
			calendarTitles = new String[] { "Not found" };

		// Set up the dropdown list navigation in the action bar.
		actionBar.setListNavigationCallbacks(
		// Specify a SpinnerAdapter to populate the dropdown list.
				new ArrayAdapter<String>(actionBar.getThemedContext(),
						android.R.layout.simple_list_item_1,
						android.R.id.text1, calendarTitles), this);
	}

	@Override
	public void onRestoreInstanceState(Bundle savedInstanceState) {
		// Restore the previously serialized current dropdown position.
		if (savedInstanceState.containsKey(STATE_SELECTED_NAVIGATION_ITEM)) {
			getActionBar().setSelectedNavigationItem(
					savedInstanceState.getInt(STATE_SELECTED_NAVIGATION_ITEM));
		}
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		// Serialize the current dropdown position.
		outState.putInt(STATE_SELECTED_NAVIGATION_ITEM, getActionBar()
				.getSelectedNavigationIndex());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onNavigationItemSelected(int position, long id) {
		// When the given dropdown item is selected, show its contents in the
		// container view.
		ArrayList<Event> events; // = calendarHandler.getEvents();
		events = fillData();
		EventDataAdapter idAdapter = new EventDataAdapter(context, events);

		ListView itemListView = (ListView) findViewById(R.id.eventsListView);
		itemListView.setAdapter(idAdapter);
		return true;
	}

	private ArrayList<Event> fillData() {
		ArrayList<Event> items = new ArrayList<Event>();
		for (int i = 0; i < 30; i++) {
			items.add(new Event(i, Rnd.getRandomString(), 
					Rnd.getRandomString(), Rnd.getRandomInt(), false));
		}
		return items;
	};
	
	/**
	 * A fragment representing a section of the app, but that simply
	 * displays dummy text.
	 */
	public static class EventListFragment extends ListFragment {
		/**
		 * The fragment argument representing the section number for this
		 * fragment.
		 */
		public static final String ARG_SECTION_NUMBER = "section_number";

		ArrayList<ItemData> items;

		public EventListFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.events_list_fragment, container, false);
	
			// TextView dummyTextView = (TextView)
			// rootView.findViewById(R.id.section_label);
			// dummyTextView.setText(Integer.toString(getArguments().getInt(ARG_SECTION_NUMBER)));
			return rootView;
		}
	}

}
