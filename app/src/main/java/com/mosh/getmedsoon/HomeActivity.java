package com.mosh.getmedsoon;

import android.content.SharedPreferences;
import android.widget.ImageView;
import android.widget.TextView;

import com.mosh.getmedsoon.SQLiteDatabaseHit.SqliteController;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * @author manish
 * 
 */
public class HomeActivity {//} extends Activity {
	ImageView imageProfile;
	TextView textViewName, textViewEmail, textViewGender, textViewBirthday;
	String textName, textGender, textBirthday, userImageUrl;
   // protected MainMedActivity mActivity=new MainMedActivity();

	//@Override
	//public void onCreate(Bundle savedInstanceState) {
    public void googgleDetails(String textEmail, SplashScreen mActivity,SharedPreferences settings){
        System.out.println("Enters this thing------>>>>");
       // super.onCreate(savedInstanceState);
		//setContentView(R.layout.activity_home);
		/*imageProfile = (ImageView) findViewById(R.id.imageView1);
		textViewName = (TextView) findViewById(R.id.textViewNameValue);
		textViewEmail = (TextView) findViewById(R.id.textViewEmailValue);
		textViewGender = (TextView) findViewById(R.id.textViewGenderValue);
		textViewBirthday = (TextView) findViewById(R.id.textViewBirthdayValue);*?

		/**
		 * get user email using intent
		 */

		//Intent intent = getIntent();
		//textEmail = intent.getStringExtra("email_id");
		//System.out.println(textEmail);
		//textViewEmail.setText(textEmail);

		/**
		 * get user data from google account
		 */

		try {
			System.out.println("On Home Page***"
					+ AbstractGetNameTask.GOOGLE_USER_DATA);
			JSONObject profileData = new JSONObject(
					AbstractGetNameTask.GOOGLE_USER_DATA);

			//if (profileData.has("picture")) {
				//userImageUrl = profileData.getString("picture");
				//new GetImageFromUrl().execute(userImageUrl);
			//}
			if (profileData.has("name")) {
				textName = profileData.getString("name");
				//textViewName.setText(textName);
			}
			if (profileData.has("gender")) {
				textGender = profileData.getString("gender");
				//textViewGender.setText(textGender);
			}
			if (profileData.has("birthday")) {
				textBirthday = profileData.getString("birthday");
				//textViewBirthday.setText(textBirthday);
			}
           /* if (profileData.has("address")) {
                textBirthday = profileData.getString("birthday");
                //textViewBirthday.setText(textBirthday);
            }*/

            SqliteController sql=new SqliteController(mActivity);
           // System.out.println("First this");
            sql.insertStudent(textName,textGender,textBirthday,textEmail,settings);

           // Intent intent=new Intent(mActivity,SqliteController.class);
            //mActivity.startActivity(intent);

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

/*	public class GetImageFromUrl extends AsyncTask<String, Void, Bitmap> {
		@Override
		protected Bitmap doInBackground(String... urls) {
			Bitmap map = null;
			for (String url : urls) {
				map = downloadImage(url);
			}
			return map;
		}

		// Sets the Bitmap returned by doInBackground
		@Override
		protected void onPostExecute(Bitmap result) {
			imageProfile.setImageBitmap(result);
		}

		// Creates Bitmap from InputStream and returns it
		private Bitmap downloadImage(String url) {
			Bitmap bitmap = null;
			InputStream stream = null;
			BitmapFactory.Options bmOptions = new BitmapFactory.Options();
			bmOptions.inSampleSize = 1;

			try {
				stream = getHttpConnection(url);
				bitmap = BitmapFactory.decodeStream(stream, null, bmOptions);
				stream.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			return bitmap;
		}

		// Makes HttpURLConnection and returns InputStream
		private InputStream getHttpConnection(String urlString)
				throws IOException {
			InputStream stream = null;
			URL url = new URL(urlString);
			URLConnection connection = url.openConnection();

			try {
				HttpURLConnection httpConnection = (HttpURLConnection) connection;
				httpConnection.setRequestMethod("GET");
				httpConnection.connect();

				if (httpConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
					stream = httpConnection.getInputStream();
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			return stream;
		}
	}*/
}