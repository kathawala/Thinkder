
////////////////////////////////////////////

@Override 
public void onCreate(Bundle icicle) { 
  super.onCreate(icicle); 
  setContentView(R.layout.main); 

  Button addImage = (Button) findViewById(R.id.send_email); 
  addImage.setOnClickListener(new View.OnClickListener() { 
    public void onClick(View view) { 
      Mail m = new Mail("derthink@gmail.com", "thinkder2014"); 
 
      String[] toArr = {"derthink@gmail.com"}; 
      m.setTo(toArr); 
      m.setFrom("derthink@gmail.com"); 
      m.setSubject("Second Level Reached"); 
      m.setBody("Email body."); 
 
      try { 
        if(m.send()) { 
          Toast.makeText(MailApp.this, "Email was sent successfully.", Toast.LENGTH_LONG).show(); 
        } else { 
          Toast.makeText(MailApp.this, "Email was not sent.", Toast.LENGTH_LONG).show(); 
        } 
      } catch(Exception e) { 
        //Toast.makeText(MailApp.this, "There was a problem sending the email.", Toast.LENGTH_LONG).show(); 
        Log.e("MailApp", "Could not send email", e); 
      } 
    } 
  }); 
} 
