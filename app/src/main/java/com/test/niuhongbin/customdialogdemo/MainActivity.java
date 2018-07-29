package com.test.niuhongbin.customdialogdemo;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void click(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View custom_title_view = getLayoutInflater().inflate(R.layout.activity_title_dialog,null);
        TextView tvTitle = custom_title_view.findViewById(R.id.tv_title);
        ImageView ivTitle = custom_title_view.findViewById(R.id.iv_title);
        tvTitle.setText("哎呦我去");
        ivTitle.setImageResource(android.R.drawable.btn_star);
        builder.setCustomTitle(custom_title_view);

        View custom_view_view = getLayoutInflater().inflate(R.layout.activity_view_dialog,null);
        final EditText etName = custom_view_view.findViewById(R.id.et_name);
        final EditText etPwd = custom_view_view.findViewById(R.id.et_pwd);
        builder.setView(custom_view_view);

        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this,etName.getText().toString()+etPwd.getText().toString(),Toast.LENGTH_SHORT).show();
            }
        }).setNegativeButton("取消",null);
        builder.show();
    }
}
