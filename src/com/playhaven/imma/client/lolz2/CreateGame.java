package com.playhaven.imma.client.lolz2;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

public class CreateGame extends Activity {

	private final View.OnClickListener mActionBarListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            onActionBarItemSelected(v.getId());
        }
    };
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_game);
        
        //TODO: There should be some detection for larger screens here, this style doesn't scale up well
        View actionBarButtons = getLayoutInflater().inflate(
        		R.layout.create_game_custom_actionbar, new LinearLayout(this), false);
        View cancelActionView = actionBarButtons.findViewById(R.id.action_discard_game);
        cancelActionView.setOnClickListener(mActionBarListener);
        View saveActionView = actionBarButtons.findViewById(R.id.action_save_game);
        saveActionView.setOnClickListener(mActionBarListener);
        
        ActionBar actionBar = getActionBar();
        actionBar.setCustomView(actionBarButtons);
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM, ActionBar.DISPLAY_SHOW_CUSTOM |
                ActionBar.DISPLAY_HOME_AS_UP | ActionBar.DISPLAY_SHOW_HOME|
                ActionBar.DISPLAY_SHOW_TITLE);
    }

    private boolean onActionBarItemSelected(int itemId) {
        switch (itemId) {
            case R.id.action_discard_game:
            	NavUtils.navigateUpFromSameTask(this);
            	return true;
            case R.id.action_save_game:
                break;
        }
        return true;
    }
    /*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //getMenuInflater().inflate(R.menu.activity_create_game, menu);
        View actionBarButtons = getLayoutInflater().inflate(R.layout.create_game_custom_actionbar, null);
        View cancelActionView = actionBarButtons.findViewById(R.id.action_discard_game);
        cancelActionView.setOnClickListener(mActionBarListener);
        View saveActionView = actionBarButtons.findViewById(R.id.action_save_game);
        saveActionView.setOnClickListener(mActionBarListener);
        
        ActionBar actionBar = getActionBar();
        actionBar.setCustomView(actionBarButtons);
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM, ActionBar.DISPLAY_SHOW_CUSTOM |
                ActionBar.DISPLAY_HOME_AS_UP | ActionBar.DISPLAY_SHOW_HOME|
                ActionBar.DISPLAY_SHOW_TITLE);
        return true;
    }
*/
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
        	case R.id.action_discard_game:
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
            case R.id.action_save_game:
            	saveGame();
            	return true;
        }
        return super.onOptionsItemSelected(item);
    }
    
    public void saveGame() {
    	return;
    }

}
