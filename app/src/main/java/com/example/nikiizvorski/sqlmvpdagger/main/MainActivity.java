package com.example.nikiizvorski.sqlmvpdagger.main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.nikiizvorski.sqlmvpdagger.R;
import com.example.nikiizvorski.sqlmvpdagger.insert.InsertActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * The type Main activity.
 */
public class MainActivity extends AppCompatActivity implements MainView, View.OnClickListener, AdapterView.OnItemClickListener {

    /**
     * The Studentslist.
     */
    @BindView(R.id.students_list) ListView studentslist;
    /**
     * The Adds.
     */
    @BindView(R.id.add_students) Button adds;
    /**
     * The Main presenter.
     */
    @Inject MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initData();
    }

    @Override
    public void initViews() {
        ButterKnife.bind(this);
        adds.setOnClickListener(this);
    }

    @Override
    public void initData() {
        DaggerMainComponent.builder().mainModule(new MainModule(this, this)).build().inject(this);
        mainPresenter.showStudents();
    }

    @Override
    public void addStudent() {
        mainPresenter.insertinDB();
    }

    @Override
    public void displayStudents() {
        ArrayAdapter<String> listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, mainPresenter.getStudents());
        studentslist.setAdapter(listAdapter);
        studentslist.setOnItemClickListener(this);
    }

    @Override
    public void goToInsertActivity() {
        Intent intent = new Intent(this, InsertActivity.class);
        startActivity(intent);
        overridePendingTransition(0,0);
    }

    @Override
    public void onClick(View v) {
        addStudent();
    }

    @Override
    protected void onDestroy() {
        mainPresenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(0,0);
        finish();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        mainPresenter.setOnItemClicked(position, parent);
    }

    @Override
    public void showmsg(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
