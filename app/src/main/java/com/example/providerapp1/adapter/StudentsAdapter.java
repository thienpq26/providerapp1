package com.example.providerapp1.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.providerapp1.R;
import com.example.providerapp1.model.Student;

import java.util.List;

public class StudentsAdapter extends RecyclerView.Adapter<StudentsAdapter.ViewHolder> {

    List<Student> mList;
    private OnNoteListener onNoteListener;

    /**
     * The constructor include full parameter of adapter
     *
     * @param mList          The list of the student
     * @param onNoteListener The interface of the adapter to click item recyclerview
     */
    public StudentsAdapter(List<Student> mList, OnNoteListener onNoteListener) {
        this.mList = mList;
        this.onNoteListener = onNoteListener;
    }

    /**
     * @param parent   The viewgrop of the adapter
     * @param viewType The viewtype of the adapter
     * @return The view of the adapter
     */
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_item_student, parent, false);
        return new ViewHolder(view, onNoteListener);
    }

    /**
     * @param holder   The viewholder of the adapter
     * @param position The position of the item
     */
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtId.setText(mList.get(position).getId() + "");
        holder.txtName.setText(mList.get(position).getName());
        holder.txtPhone.setText(mList.get(position).getPhone());
        holder.txtAddress.setText(mList.get(position).getAddress());
        holder.txtEmail.setText(mList.get(position).getEmail());
    }

    /**
     * @return The item count
     */
    @Override
    public int getItemCount() {
        return mList.size();
    }

    /**
     * The viewholder of the adapter
     */
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView txtId;
        TextView txtName;
        TextView txtPhone;
        TextView txtAddress;
        TextView txtEmail;
        OnNoteListener onNoteListener;

        public ViewHolder(@NonNull View itemView, OnNoteListener onNoteListener) {
            super(itemView);
            txtId = itemView.findViewById(R.id.txtId);
            txtName = itemView.findViewById(R.id.txtName);
            txtPhone = itemView.findViewById(R.id.txtPhone);
            txtAddress = itemView.findViewById(R.id.txtAddress);
            txtEmail = itemView.findViewById(R.id.txtEmail);
            this.onNoteListener = onNoteListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onNoteListener.onNoteClick(getAdapterPosition());
        }
    }

    public interface OnNoteListener {
        void onNoteClick(int position);
    }
}
