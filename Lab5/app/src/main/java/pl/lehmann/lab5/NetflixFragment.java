package pl.lehmann.lab5;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class NetflixFragment extends Fragment {

    private long netflixId;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            netflixId = savedInstanceState.getLong("netflixId");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_netflix, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        View view = getView();
        if (view != null) {
            TextView name = (TextView) view.findViewById(R.id.name);
            Netflix netflix = Netflix.series[(int) netflixId];
            name.setText(netflix.getName());
            TextView description = (TextView) view.findViewById(R.id.description);
            description.setText(netflix.getDescription());
            TextView seasons = (TextView) view.findViewById(R.id.seasons);
            seasons.setText(netflix.getSeasons());
            ImageView photo = (ImageView) view.findViewById(R.id.photo);
            photo.setImageResource(netflix.getImageResourceId());
            photo.setContentDescription(netflix.getName());
        }
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putLong("netflixId", netflixId);
    }

    public void setNetflix(long id) {
        this.netflixId = id;
    }
}
