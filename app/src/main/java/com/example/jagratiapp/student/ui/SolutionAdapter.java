package com.example.jagratiapp.student.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jagratiapp.R;
import com.example.jagratiapp.model.Question;

import java.util.List;
import java.util.Map;

import static android.graphics.Color.rgb;

public class SolutionAdapter extends RecyclerView.Adapter<SolutionAdapter.ViewHolder> {
    private List<Question> questonList;
    private Map<String,String> answerMap;
    private Context context;

    public SolutionAdapter(Context context,List<Question> questionList, Map<String, String> answerMap) {
        this.questonList = questionList;
        this.answerMap = answerMap;
        this.context = context;
    }

    @NonNull
    @Override
    public SolutionAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.question_solution_cardview,parent,false);
        return new ViewHolder(view);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull SolutionAdapter.ViewHolder holder, int position) {
        AppCompatRadioButton rb;
        rb = new AppCompatRadioButton(context);
        ColorStateList colorStateList = new ColorStateList(
                new int[][]{
                        new int[]{-android.R.attr.state_checked},
                        new int[]{android.R.attr.state_checked}
                },
                new int[]{
                        Color.DKGRAY
                        , rgb(255, 0, 0),
                }
        );

        ColorStateList correctStateList = new ColorStateList(
                new int[][]{
                        new int[]{-android.R.attr.state_checked},
                        new int[]{android.R.attr.state_checked}
                },
                new int[]{
                        Color.DKGRAY
                        , rgb(0, 128, 0),
                }
        );

        Question question = questonList.get(position);
        String answer = question.getCorrectOption();
//        Toast.makeText(context,question.getQuestionId(),Toast.LENGTH_SHORT).show();
        holder.question.setText((++position) +". " +(question.getQuestion()));
        holder.optionA.setText(question.getOption1());
        holder.optionA.setClickable(false);
        holder.optionB.setText(question.getOption2());
        holder.optionB.setClickable(false);
        holder.optionC.setText(question.getOption3());
        holder.optionC.setClickable(false);
        holder.optionD.setText(question.getOption4());
        holder.optionD.setClickable(false);

        String correctAnswer = question.getCorrectOption();

        if (correctAnswer.equals(question.getOption1())) {
            holder.optionA.setChecked(true);
            holder.optionA.setButtonTintList(correctStateList);
        }
        else if (correctAnswer.equals(question.getOption2())){
            holder.optionB.setChecked(true);
            holder.optionB.setButtonTintList(correctStateList);
        }

        else if (correctAnswer.equals(question.getOption3())) {
            holder.optionC.setChecked(true);
            holder.optionC.setButtonTintList(correctStateList);
        }
        else if (correctAnswer.equals(question.getOption4()))
        {
            holder.optionD.setChecked(true);
            holder.optionD.setButtonTintList(correctStateList);
        }


        if (answerMap != null && answerMap.containsKey(question.getQuestionId())) {
            answer = answerMap.get(question.getQuestionId());
            if (!correctAnswer.equals(answer)) {
                holder.result.setText("Incorrect Answer");
                holder.result.setTextColor(rgb(200, 0, 0));
                if (answer.equals(question.getOption1())) {
                    holder.optionA.setChecked(true);
                    holder.optionA.setButtonTintList(colorStateList);
                }
                else if (answer.equals(question.getOption2())) {
                    holder.optionB.setChecked(true);
                    holder.optionB.setButtonTintList(colorStateList);
                }
                else if (answer.equals(question.getOption3())) {
                    holder.optionC.setChecked(true);
                    holder.optionC.setButtonTintList(colorStateList);
                }
                else if (answer.equals(question.getOption4())) {
                    holder.optionD.setChecked(true);
                    holder.optionD.setButtonTintList(colorStateList);
                }
            }
            else {
                holder.result.setText("Correct Answer");
                holder.result.setTextColor(rgb(0, 128, 0));
            }
        }
        else {
            holder.result.setText("Not Given");
            holder.result.setTextColor(rgb(255, 0, 0));
        }
    }

    @Override
    public int getItemCount() {
        return questonList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView question;
        private RadioButton optionA;
        private RadioButton optionB;
        private RadioButton optionC;
        private RadioButton optionD;
        private TextView result;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.question = itemView.findViewById(R.id.question);
            this.optionA = itemView.findViewById(R.id.optionA);
            this.optionB = itemView.findViewById(R.id.optionB);
            this.optionC = itemView.findViewById(R.id.optionC);
            this.optionD = itemView.findViewById(R.id.optionD);
            this.result = itemView.findViewById(R.id.correct_answer);

        }
    }
}
