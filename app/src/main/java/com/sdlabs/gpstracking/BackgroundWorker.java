package com.sdlabs.gpstracking;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.JsonReader;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import javax.net.ssl.HttpsURLConnection;
 /* Created by Saransh Dabas */

public class BackgroundWorker extends AsyncTask<String, Void, String> {

    Context context;
    AlertDialog alertDialog;
    private static final String TAG = "BackGroundWorker";

    BackgroundWorker(Context ctx)
    {
        context = ctx;
    }

    @Override
    protected String doInBackground(String... params) {
        String type = params[0];
        String userInfo = params[1];
        int a = 0;
        if (type.equals("login")) {
            a = getUserInfo(userInfo);
            Log.e(TAG, ""+a);
        }
        return Integer.toString(a);
    }
        /*String login_url = "http://172.17.31.146/login.php";
        String register_url = "http://172.17.31.146/register.php";
        String email_url = "http://172.17.31.146/changeEmail.php";
        String password_url = "http://172.17.31.146/changePassword.php";
        String username_url = "http://172.17.31.146/changeUsername.php";
        String recover_url = "http://172.17.31.146/recoverPassword.php";

        if(type.equals("login"))
        {
            try {
                String user_name = params[1];
                String user_password = params[2];
                URL url = new URL(login_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();//connection object
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("user_name","UTF-8")+"="+URLEncoder.encode(user_name,"UTF-8")+"&"+URLEncoder.encode("user_password","UTF-8")+"="+URLEncoder.encode(user_password,"UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
                String result = "";
                String line="";
                while((line = bufferedReader.readLine())!= null)
                {
                    result += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;
            } catch(MalformedURLException e){
                e.printStackTrace();
            } catch (IOException e){
                e.printStackTrace();
            }


        }

        else if(type.equals("register")) {
            try {
                String user_key = params[1];
                String user_email = params[2];
                String user_name = params[3];
                String user_password = params[4];
                URL url = new URL(register_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("user_key", "UTF-8") + "=" + URLEncoder.encode(user_key, "UTF-8")
                        + "&" + URLEncoder.encode("user_email", "UTF-8") + "=" + URLEncoder.encode(user_email, "UTF-8")
                        + "&" + URLEncoder.encode("user_name", "UTF-8") + "=" + URLEncoder.encode(user_name, "UTF-8")
                        + "&" + URLEncoder.encode("user_password", "UTF-8") + "=" + URLEncoder.encode(user_password, "UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String result = "";
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    result += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        else if(type.equals("Email"))
        {
            try {
                String old_email = params[1];
                String new_email = params[2];
                URL url = new URL(email_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("old_email","UTF-8")+"="+URLEncoder.encode(old_email,"UTF-8")
                        +"&"+URLEncoder.encode("new_email","UTF-8")+"="+URLEncoder.encode(new_email,"UTF-8");

                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
                String result = "";
                String line = "";
                while((line = bufferedReader.readLine())!= null)
                {
                    result += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;
            } catch(MalformedURLException e){
                e.printStackTrace();
            } catch (IOException e){
                e.printStackTrace();
            }


        }
        else if(type.equals("Password")) {
            try {
                String old_password = params[1];
                String new_password = params[2];
                URL url = new URL(password_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("old_password", "UTF-8") + "=" + URLEncoder.encode(old_password, "UTF-8")
                        + "&" + URLEncoder.encode("new_password", "UTF-8") + "=" + URLEncoder.encode(new_password, "UTF-8");

                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String result = "";
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    result += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        else if(type.equals("Username")) {
            try {
                String old_username = params[1];
                String new_username = params[2];
                URL url = new URL(username_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("old_username", "UTF-8") + "=" + URLEncoder.encode(old_username, "UTF-8")
                        + "&" + URLEncoder.encode("new_username", "UTF-8") + "=" + URLEncoder.encode(new_username, "UTF-8");

                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String result = "";
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    result += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        else if(type.equals("Recover"))
        {
            try {
                String old_key = params[1];
                String reset_password = params[2];
                URL url = new URL(recover_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("old_key","UTF-8")+"="+URLEncoder.encode(old_key,"UTF-8")
                        +"&"+URLEncoder.encode("reset_password","UTF-8")+"="+URLEncoder.encode(reset_password,"UTF-8");

                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
                String result = "";
                String line = "";
                while((line = bufferedReader.readLine())!= null)
                {
                    result += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;
            } catch(MalformedURLException e){
                e.printStackTrace();
            } catch (IOException e){
                e.printStackTrace();
            }


        }

        return null;
    }*/

    public int getUserInfo(String userInfo){

        try {
            Uri.Builder builder = new Uri.Builder();
            builder.scheme("https")
                    .authority("smart-farming-makeathon.herokuapp.com")
                    .appendPath("api")
                    .appendPath("farms")
                    .appendPath(userInfo);

            URL herokuEndpoint = new URL(builder.build().toString());

            HttpsURLConnection mConnection =
                    (HttpsURLConnection) herokuEndpoint.openConnection();

            if (mConnection.getResponseCode() == 200) {
                // Success
                InputStream responseBody = mConnection.getInputStream();
                InputStreamReader responseBodyReader = new InputStreamReader(responseBody, "UTF-8");
                JsonReader jsonReader = new JsonReader(responseBodyReader);


                jsonReader.beginObject(); // Start processing the JSON object
                while (jsonReader.hasNext()) { // Loop through all keys
                    String key = jsonReader.nextName(); // Fetch the next key
                    if (key.equals("data")) { // Check if desired key
                        // Fetch the value as a String
                        jsonReader.beginObject();
                        User user = new User();
                        while(jsonReader.hasNext()) {
                            String name = jsonReader.nextName();
                            if (name.equals("id"))
                                user.setID(jsonReader.nextString());
                            else if (name.equals("phone"))
                                user.setPhone(jsonReader.nextString());
                            else if (name.equals("name"))
                                user.setName(jsonReader.nextString());
                            else if (name.equals("password"))
                                user.setPassword(jsonReader.nextString());
                            else if (name.equals("plots"))
                                user.setPlot(jsonReader.nextInt());
                            else
                                jsonReader.skipValue();
                        }
                        jsonReader.endObject();
                    }
                    else {
                        jsonReader.skipValue(); // Skip values of other keys
                    }
                }
                jsonReader.endObject();
            }
            else {
                // Error handling code goes here
                Toast.makeText(context, "Cannot connect to API!",
                        Toast.LENGTH_LONG).show();
                return -1;
            }
        }
        catch (Exception e){
            Log.w(TAG, e);
            return -1;
        }
        return 0;
    }

    public int newUser(User user){

        try {
            Uri.Builder builder = new Uri.Builder();
            builder.scheme("https")
                    .authority("smart-farming-makeathon.herokuapp.com")
                    .appendPath("api")
                    .appendPath("farms")
                    .appendPath(user.getId());

            URL herokuEndpoint = new URL(builder.build().toString());
            HttpsURLConnection mConnection =
                    (HttpsURLConnection) herokuEndpoint.openConnection();
            mConnection.setRequestMethod("PUT");
            mConnection.setRequestProperty("USER-AGENT", "Mozilla/5.0");
            mConnection.setRequestProperty("ACCEPT-LANGUAGE", "en-US,en;0.5");
            mConnection.setDoOutput(true);
            String params = "phone="+URLEncoder.encode(user.getPhone(),"UTF-8")
                    +"&name="+URLEncoder.encode(user.getName(),"UTF-8")
                    +"&password="+URLEncoder.encode(user.getPassword(),"UTF-8")
                    +"&plots="+URLEncoder.encode(""+user.getPlots(),"UTF-8");
            DataOutputStream dStream = new DataOutputStream(mConnection.getOutputStream());
            dStream.writeBytes(params);
            dStream.flush();
            dStream.close();
            int responseCode = mConnection.getResponseCode();
            if(responseCode != 200) {
                Log.e(TAG, "" + responseCode);
                return -1;
            }
            else
                return 0;
        }
        catch (Exception e){
            Log.w(TAG, e);
            return -1;
        }
    }

    public int getPlots(Plots plot){
    return 0;
    }

    public int newPlots(Plots plot){
        return 0;
    }

    @Override
    protected void onPreExecute() {
        alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setTitle("Login Status");
    }

    @Override
    protected void onPostExecute(String result) {



        result = "login success !!!!! Welcome user";

        if("login success !!!!! Welcome user".equalsIgnoreCase(result)) {
                context.startActivity(new Intent(context, choose_options.class));
                alertDialog.setMessage(result);
                alertDialog.show();



        }else {
            alertDialog.setMessage(result);
            alertDialog.show();
        }

    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }
}
