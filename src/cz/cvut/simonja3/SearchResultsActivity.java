package cz.cvut.simonja3;

import android.app.ListActivity;
import android.os.Bundle;

public class SearchResultsActivity extends ListActivity {
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.searchresults);
	}

}
