package com.example.nikiizvorski.sqlmvpdagger.insert;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nikiizvorski.sqlmvpdagger.R;
import com.example.nikiizvorski.sqlmvpdagger.main.MainActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * The type Insert activity.
 */
public class InsertActivity extends AppCompatActivity implements InsertView, View.OnClickListener{
    /**
     * The Name.
     */
    @BindView(R.id.editTextName) EditText name;
    /**
     * The Phone.
     */
    @BindView(R.id.editTextPhone) EditText phone;
    /**
     * The Email.
     */
    @BindView(R.id.editTextEmail) EditText email;
    /**
     * The Street.
     */
    @BindView(R.id.editTextStreet) EditText street;
    /**
     * The City.
     */
    @BindView(R.id.editTextCity) EditText city;
    /**
     * The Save in db.
     */
    @BindView(R.id.button1) Button saveInDb;
    /**
     * The Insert presenter.
     */
    @Inject InsertPresenter insertPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);
        initViews();
        initData();
    }

    @Override
    public void initViews() {
        ButterKnife.bind(this);
        saveInDb.setOnClickListener(this);
    }

    @Override
    public void initData() {
        DaggerInsertComponent.builder().insertModule(new InsertModule(this, this)).build().inject(this);
    }

    @Override
    public void onClick(View v) {
        insertPresenter.getStudent();
    }

    @Override
    public void getDataFromViews(){
        dataForPresenter(name.getText().toString(), phone.getText().toString(), email.getText().toString(), street.getText().toString(), city.getText().toString());
    }

    @Override
    public void dataForPresenter(String name, String phone, String email, String street, String city){
        insertPresenter.insertStudent(name, phone, email, street, city);
        Toast.makeText(this, "Contact Added!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showCityError() {
        Toast.makeText(this, "City Error!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showStreetError() {
        Toast.makeText(this, "Street Error!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showEmailError() {
        Toast.makeText(this, "Email Error!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showPhoneError() {
        Toast.makeText(this, "Phone Error!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showNameError() {
        Toast.makeText(this, "Name Error!", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        insertPresenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(0,0);
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
        overridePendingTransition(0,0);
    }
}
