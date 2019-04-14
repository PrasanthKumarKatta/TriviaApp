package com.kpcode4u.triviaapp.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.kpcode4u.triviaapp.R;
import com.kpcode4u.triviaapp.RoomDatabase.QuizEntitiy;

import java.util.List;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.HistoryInfo> {
    private Context context;
    List<QuizEntitiy> arrayList;
    RecyclerView rv;

    public HistoryAdapter(Context context, List<QuizEntitiy> arrayList, RecyclerView rv)
    {
        this.context = context;
        this.arrayList = arrayList;
        this.rv = rv;
    }

    @NonNull
    @Override
    public HistoryInfo onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(context).inflate(R.layout.row_history, viewGroup, false);
        return new HistoryInfo(v);
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryInfo historyInfo, int i)
    {
        historyInfo.gId.setText("GAME  "+arrayList.get(i).getId()+" :");
        historyInfo.date.setText(arrayList.get(i).getDateTime());
        historyInfo.uName.setText(arrayList.get(i).getName());
        historyInfo.q1Ans.setText(arrayList.get(i).getQ1Ans());
        historyInfo.q2Ans.setText(arrayList.get(i).getQ2Ans());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class HistoryInfo extends RecyclerView.ViewHolder {
        TextView gId,date, uName, q1Ans, q2Ans;

        HistoryInfo(@NonNull View itemView) {
            super(itemView);

            gId = itemView.findViewById(R.id.game_id_history);
            date = itemView.findViewById(R.id.date_time_history);
            uName = itemView.findViewById(R.id.uName_history);
            q1Ans = itemView.findViewById(R.id.q1_ans__history);
            q2Ans = itemView.findViewById(R.id.q2_ans__history_row);

        }
    }
}
