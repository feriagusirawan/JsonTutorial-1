package adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.pcp.jsontutorial.R;

import java.util.ArrayList;
import java.util.List;

import model.Episode;

/**
 * Created by Pcp on 17/01/2017.
 */

public class EpisodesAdapter extends RecyclerView.Adapter<EpisodesAdapter.EpisodesHolder> {

    List<Episode> episodes = new ArrayList<>();
    Context context;

    public EpisodesAdapter(Context context) {
        this.context = context;
    }

    @Override
    public EpisodesHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context)
                .inflate(R.layout.episode_row, parent, false);
        return new EpisodesHolder(v);
    }

    @Override
    public void onBindViewHolder(EpisodesHolder holder, int position) {
        holder.season.setText(String.valueOf(episodes.get(position).getSeason()));
        holder.name.setText(episodes.get(position).getName());
        holder.number.setText(String.valueOf(episodes.get(position).getNumber()));
    }

    @Override
    public int getItemCount() {
        return episodes.size();
    }

    public void updateDataSet(List<Episode> episodes) {
        this.episodes.clear();
        this.episodes.addAll(episodes);
        this.notifyDataSetChanged();
    }

    class EpisodesHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView season;
        TextView name;
        TextView number;

        public EpisodesHolder(View itemView) {
            super(itemView);
            season = (TextView) itemView.findViewById(R.id.season_row);
            name = (TextView) itemView.findViewById(R.id.name_row);
            number = (TextView) itemView.findViewById(R.id.number_row);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

        }
    }

}