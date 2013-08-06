package com.hinck.birthdayemail;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;

public class Email extends Activity implements View.OnClickListener {

	EditText personsEmail, intro, years, stupidThings, hatefulAction, outro;
	String emailAdd, age, name, stupidAction, hatefulAct, out;
	Button sendEmail;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.email);
		initializeVars();
		sendEmail.setOnClickListener(this);
	}

	private void initializeVars() {
		// TODO Auto-generated method stub
		personsEmail = (EditText) findViewById(R.id.etEmails);
		intro = (EditText) findViewById(R.id.etName);
		years = (EditText) findViewById(R.id.etYears);
		stupidThings = (EditText) findViewById(R.id.etThings);
		hatefulAction = (EditText) findViewById(R.id.etAction);
		outro = (EditText) findViewById(R.id.etOutro);
		sendEmail = (Button) findViewById(R.id.bSentEmail);
	}

	public void onClick(View v) {
		// TODO Auto-generated method stub

		convertEditTextVarsIntoStringsAndYesThisIsAMethodWeCreated();
		String emailaddress[] = { emailAdd };
		String message = "Happy Birthday "
				+ name
				+ "!"
				+ '\n'
				+ '\n'
				+ '\n'
				+ "Congratulations on "
				+ age
				+ " years."
				+ "  It was great "
				+ stupidAction
				+ " you last time.  We should definitely do it again soon.  Anyways, enjoy your special day."
				+ '\n' + '\n' + hatefulAct + '\n' + out;

		Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
		emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, emailaddress);
		emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT,
				"Happy Birthday!");
		emailIntent.setType("plain/text");
		emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, message);
		startActivity(emailIntent);

	}

	private void convertEditTextVarsIntoStringsAndYesThisIsAMethodWeCreated() {
		// TODO Auto-generated method stub
		emailAdd = personsEmail.getText().toString();
		name = intro.getText().toString();
		age = years.getText().toString();
		stupidAction = stupidThings.getText().toString();
		hatefulAct = hatefulAction.getText().toString();
		out = outro.getText().toString();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}

}
