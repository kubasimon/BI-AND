package cz.cvut.simonja3;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class SearchResultsActivity extends ListActivity {
	
	
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.searchresults);
        
                
        
        String[] names = new String[] { "èesnáèek lékaøský", "èesnáèek lékaøský", "èesnáèek lékaøský",};
        
        final SearchResultsAdapter adapter = new SearchResultsAdapter(this, R.layout.rowlayout,
        		names);
        
        this.setListAdapter(adapter);
	}
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
	        super.onListItemClick(l, v, position, id);
	        
	        Object o = this.getListAdapter().getItem(position);
	        String keyword = o.toString();
	        Toast.makeText(this, "You selected: " + keyword, Toast.LENGTH_LONG)
	                .show();
	        switchToDetail(v);
	}
	
	public void switchToDetail(View view) {
		Intent intent = new Intent(view.getContext(), DetailActivity.class);
    	this.startActivity(intent);
	}
	
	private static class SearchResultsAdapter extends ArrayAdapter<String> {

		private final Context mContext;
		private final int mResourceId;
		
		static class ViewHolder{
			public TextView czechName;
			public TextView latinName;
			public ImageView photo;
		}

		public SearchResultsAdapter(Context context, int resource, String[] objects) {
			super(context, resource, objects);
			mContext = context;
			mResourceId = resource;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			View plantView;
			LayoutInflater inflater = (LayoutInflater) mContext
					.getSystemService(LAYOUT_INFLATER_SERVICE);
			
			if (convertView != null) {
				plantView = convertView;
			} else {
				plantView = inflater.inflate(mResourceId, null, true);
				ViewHolder viewHolder = new ViewHolder();
				viewHolder.czechName = (TextView) plantView.findViewById(R.id.czechName);
				viewHolder.latinName = (TextView) plantView.findViewById(R.id.latinName);
				viewHolder.photo = (ImageView) plantView.findViewById(R.id.photo);
				plantView.setTag(viewHolder);
			}

			ViewHolder viewHolder = (ViewHolder) plantView.getTag();
			
			viewHolder.czechName.setText(getItem(position));
			viewHolder.latinName.setText(getItem(position));
			viewHolder.photo.setImageResource(R.drawable.kvet);
			

			return plantView;
		}
		
	}
	
}
