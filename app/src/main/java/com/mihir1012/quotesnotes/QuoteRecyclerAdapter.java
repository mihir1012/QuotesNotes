package com.mihir1012.quotesnotes;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class QuoteRecyclerAdapter extends RecyclerView.Adapter<QuoteRecyclerAdapter.QuoteViewHolder> {

    List<String> quotes = null;
    Context context;

    public QuoteRecyclerAdapter(List<String> quotes, Context context) {
        this.quotes = quotes;
        this.context = context;
    }

    @NonNull
    @Override
    public QuoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.quote_item_layout,parent,false);
        return new QuoteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull QuoteViewHolder holder, int position) {
        String[] colors = {"#448AFF","#FFC107","#009688","#E91E63","#FF5722"};
        String quote = quotes.get(position);
        holder.textView.setText(quote);
        int color = position % colors.length;
        int intColor = Color.parseColor(colors[color]);
        holder.linearLayout.setBackgroundColor(intColor);

    }

    @Override
    public int getItemCount() {
        return quotes.isEmpty()? 0:quotes.size();
    }

    public class QuoteViewHolder extends RecyclerView.ViewHolder{

        TextView textView;
        LinearLayout linearLayout;

        public QuoteViewHolder(@NonNull View itemView) {
            super(itemView);
            textView  = itemView.findViewById(R.id.textQuote);
            linearLayout = itemView.findViewById(R.id.quoteContainer);

        }
    }
}
