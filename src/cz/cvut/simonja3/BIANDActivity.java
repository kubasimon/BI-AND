package cz.cvut.simonja3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class BIANDActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
    
    public void switchToSearch(View view) {
    	Intent intent = new Intent(view.getContext(), SearchActivity.class);
    	this.startActivity(intent);
    }
}