int rx = 400;
int ry = 300;
int ac=0;
int time;
int wait = 10000;
int mouseDragX;
int mouseDragY;
int varx;
float vary;
int trex;
int trey;
int startx;
int starty;
String CI;
int TX;
int TY;
int TW;
int TH;
int BBX;
int BBY;
int BBW;
int BBH;
int HBX;
int HBY;
int HBW;
int HBH;
int kevx;
int ABW;
int ABH;
int ABX;
int ABY;
int TPH;
int TPX;
int TPY;
PrintWriter tdefcoords;
PrintWriter defcoords;
BufferedReader fcr;
BufferedReader treader;
BufferedReader reader;
String fch;
String defcoordshelp;
String tdefcoordshelp;
PrintWriter sdefcoords;
BufferedReader sreader;
String sdefcoordshelp;
int inTP=0;
String kevX;
String kevY;
int insideBegin = 0;
int HelpClick=0;
int bx=400;
int by=300;
int hFirstTouch=0;
PFont SNAPITC;
int BeginClick=0;
int rounddw= displayWidth/1;
int rounddh=displayWidth/3;
  void droplet(int x1, int x2) {
    PImage raindrop;
    raindrop = loadImage("droplet.png");
    raindrop.resize(displayWidth/250,displayHeight/50);
    image(raindrop,rx,ry);
  }

void setup() {
  size(displayWidth,displayHeight);
  //DELETES DEFCOORDS.TXT IF IT'S THERE
  String deldc = sketchPath("defcoords.txt");
  File del = new File(deldc);
  if (del.exists()) {
    del.delete();
  }
    String delsdc = sketchPath("sdefcoords.txt");
  File sdel = new File(delsdc);
  if (sdel.exists()) {
    sdel.delete();
  }
    String deltdc = sketchPath("tdefcoords.txt");
  File tdel = new File(deltdc);
  if (tdel.exists()) {
    tdel.delete();
  }
  
  if (BeginClick==0){
  PImage background;
  background = loadImage("raint.jpg");
  background.resize(displayWidth,displayHeight);
  image(background,0,0);
  PImage Title;
  TW=displayWidth/1; 
  TH=displayHeight/2;
  Title = loadImage("title5.png");
  Title.resize(TW,TH);   
  TX=(displayWidth/2)-TW/2;
  TY=(displayHeight/TH);
  image(Title,TX,displayHeight/TH);
  
  //DRAWS THE BEGIN BUTTON
  
  BBW=displayWidth/3;
  BBH=displayHeight/6;
  BBX=(displayWidth/2)-BBW/2;
  BBY=displayHeight/TH+(TH+(BBH/4));
  
  fill(67,91,213);
  stroke(47,54,153);  
  strokeWeight(7);
  rect(BBX,BBY,BBW,BBH); 
  fill(47,54,153);
  SNAPITC = loadFont("SnapITC-Regular-48.vlw");
  textFont(SNAPITC,BBH);
  String Begin = "Begin";
  float BtS=BBH;
  while(textWidth(Begin)>(displayHeight/2-BBH/2)){
  BtS-=1;
  textSize(BtS);
  

  }
  text("Begin",BBX+(BBW-textWidth(Begin))/2,BBY+(BBH*.8));
  
  //DRAWS THE HELP BUTTON
  HBW=displayWidth/3;
  HBH=displayHeight/6;
  HBX=(displayWidth/2)-HBW/2;
  HBY=displayHeight/TH+TH+(HBH+(HBH/2));
  
  fill(67,91,213);
  stroke(47,54,153);  
  strokeWeight(7);
  rect(HBX,HBY,HBW,HBH); 
  fill(47,54,153);
  SNAPITC = loadFont("SnapITC-Regular-48.vlw");
  textFont(SNAPITC,HBH);
  String Help = "Help";
  float HtS=HBH;
  while(textWidth(Help)>(displayHeight/2-HBH/2)){
  HtS-=1;
  textSize(HtS);


  }
  text("Help",HBX+(HBW-textWidth(Help))/2,HBY+(HBH*.8));
  }  
  time=millis();  
}
  
  

void draw() {
  
  if(BeginClick==1){ 
  PImage img;
  img = loadImage("SHEEP.jpg");
  img.resize(displayWidth,displayHeight);
  image(img,1,1);
  }


//TUTORIAL
if(HelpClick==1){ 
  
  //RAINDROPS ON TOP LEFT
  int pdw = displayWidth/20;
  int pdh = displayHeight/13;
  int pd2x=pdw++;
  int pd3x=pdw+pdw++;
  
  PImage img;
  img = loadImage("instructions.png");
  img.resize(displayWidth,displayHeight);
  image(img,0,0);
  
  PImage pd1;
  pd1 = loadImage("pdroplettt.png");
  pd1.resize(pdw,pdh);
  image(pd1,0,0);

  PImage pd2;
  pd2 = loadImage("pdroplettt.png");
  pd2.resize(displayWidth/20,displayHeight/13);
  image(pd2,pd2x,0);
  
  PImage pd3;
  pd3 = loadImage("pdroplettt.png");
  pd3.resize(displayWidth/20,displayHeight/13);
  image(pd3,pd3x,0);
  
  //RAINDROPS ON BOTTOM LEFT
  
  float pd4y=displayHeight-(pdh*1.5);
  float pd5x=0+pdw++;
  float pd6x=pd5x+pdw++;
  
  PImage pd4;
  pd4 = loadImage("pdroplettt.png");
  pd4.resize(pdw,pdh);
  image(pd4,0,pd4y);

  PImage pd5;
  pd5 = loadImage("pdroplettt.png");
  pd5.resize(displayWidth/20,displayHeight/13);
  image(pd5,pd5x,pd4y);
  
  PImage pd6;
  pd6 = loadImage("pdroplettt.png");
  pd6.resize(displayWidth/20,displayHeight/13);
  image(pd6,pd6x,pd4y);
  
  //RAINDROPS ON TOP RIGHT
  
  float pd7x=displayWidth-(pdw*1.15);
  float pd8y=0+pdh++;
  float pd9y=0+pdh+pdh++;
  
  PImage pd7;
  pd7 = loadImage("pdroplettt.png");
  pd7.resize(pdw,pdh);
  image(pd7,pd7x,0);

  PImage pd8;
  pd8 = loadImage("pdroplettt.png");
  pd8.resize(displayWidth/20,displayHeight/13);
  image(pd8,pd7x,pd8y);
  
  PImage pd9;
  pd9 = loadImage("pdroplettt.png");
  pd9.resize(displayWidth/20,displayHeight/13);
  image(pd9,pd7x,pd9y);
  
  //DRAWS SWORD BUTTON
  
/*  if (hFirstTouch==1){
  
  }*/
  
  //DRAWS ALT BUTTON
  ABH=displayHeight/12;
  ABW=displayWidth/12;
  ABX=(displayWidth-ABH-(displayWidth/25));
  ABY=(displayHeight-(displayWidth/5)-(ABH));
  
  fill(67,91,213);
  stroke(47,54,153);
  strokeWeight(7);
  rect(ABX,ABY,ABW,ABH); 
  
  PImage alt;
  alt = loadImage("alt.png");
  alt.resize(ABW,ABH);
  image(alt,ABX,ABY);
  
  //CHARACTER SWITCHES
  
  CI="kev1.png";
  //if(ac==1){CI="kev6.png";}
 // if(ac==2){CI="kev9.png";}
  
  if(ac==1){
      CI="kev6.png";
      int inAB=1;
  }
  
  
  
  
  
  
  
  //DRAWS CHARACTER
  PImage kev;
  kev = loadImage(CI);
  kev.resize(displayWidth/5,displayHeight/3);
  int kevw=displayWidth/5;
  int kevh=displayHeight/3;
  
  if(hFirstTouch==0){
  int kevx=displayWidth-(displayWidth/3);
  float kevy=displayHeight-(displayHeight/2.5);
  image(kev,kevx,kevy);
  }
  

  
  //IF FINGER IS IN TOUCHPAD, AND DRAGGED MOVE KEVIN AROUND.
  
    
  
  int startx=displayWidth-(displayWidth/3);
  float starty=(displayHeight-(displayHeight/2.5));
  
  //IF SDEFCOORDS DONT EXIST, MOVE CHAR AROUND AND MAKE DEFCOORDS; SO THAT IT WILL ONLY START CHAR FROM STARTXY BEFORE THE MOUSE LEAVES THE TOUCHPAD FOR THE FIRST TIME
    File Sdefcoords = new File(sketchPath("sdefcoords.txt"));
    File fcheck = new File(sketchPath("defcoords.txt"));
  if((!(((mouseX > ( TPX+TPH))||(mouseY > (TPY+TPH)))||((mouseX < TPX)||(mouseY < TPY))))){
    if(!(Sdefcoords.exists())){
    int kevx=startx+mouseDragX;
    float kevy=starty+mouseDragY;
    
  //SEND LAST KNOWN COORDS IN TOUCHPAD TO FILE
  defcoords = createWriter("defcoords.txt");
  defcoords.println(kevx + "\t" + kevy);
  defcoords.flush();
  defcoords.close();
  //SETS KEVIN TO STARTXY + VALUE OF MOUSEDRAGXY
  image(kev,kevx,kevy);
  int inTP=1;
    }
    
    
 //   IF THE SDEFCOORDS EXIST, AND DEFCOORDS EXISTS
 
    if(Sdefcoords.exists()){
      if(fcheck.exists()){
     //   if(((!mousePressed)||(!(((mouseX > ( TPX+TPH))||(mouseY > (TPY+TPH)))||((mouseX < TPX)||(mouseY < TPY))))))
   
        //READ DEFCOORDS
        
        fcr = createReader("defcoords.txt");
  try {
    fch = fcr.readLine();
  } catch (IOException e) {
    e.printStackTrace();
    fch = null;
  }
  if (fch == null) {
    // Stop reading because of an error or file is empty
    noLoop();  
  } else {
    String[] pieces = split(fch, TAB);
    
    //INTS FCXY = DEFCOORD CONTENTS
    int fcx = int(pieces[0]);
    int fcy = int(pieces[1]);
    
      //VARS KEVXY = FCXY+MOUSEDRAGXY
    int kevx=fcx+mouseDragX;
    float kevy=fcy+mouseDragY;

  //SEND LAST KNOWN COORDS OF KEV WHEN HE WAS IN THE TOUCHPAD TO A FILE
  defcoords = createWriter("defcoords.txt");
  defcoords.println(kevx + "\t" + kevy);
  defcoords.flush();
  defcoords.close();
  
  //SETS KEVIN TO FCXY + VALUE OF MOUSEDRAGXY
  
  image(kev,kevx,kevy);
  int inTP=1;
  }
      }//*fcheckclose
    }
  }
  
  
    
  File defcoords = new File(sketchPath("defcoords.txt"));
  if(defcoords.exists()&&!(!(((mouseX > ( TPX+TPH))||(mouseY > (TPY+TPH)))||((mouseX < TPX)||(mouseY < TPY))))){
reader = createReader("defcoords.txt");
  try {
    defcoordshelp = reader.readLine();
  } catch (IOException e) {
    e.printStackTrace();
    defcoordshelp = null;
  }
  if (defcoordshelp == null) {
    // Stop reading because of an error or file is empty
    noLoop();  
  } else {
    String[] pieces = split(defcoordshelp, TAB);
    int x = int(pieces[0]);
    int y = int(pieces[1]);
    image(kev,x, y);

//GETS THE SDEFCOORDS, DEFCOORDS WHEN MOUSE WASNT ON TOUCHPAD; ONLY IF DEFCOORDS EXIST
  sdefcoords = createWriter("sdefcoords.txt");
  sdefcoords.println(x + "\t" + y);
  sdefcoords.flush();
  sdefcoords.close();
  }
  }
//**************************************************************************************************************************************************************************
    //IF THE SDEFCOORDS EXIST, AND MOUSE IS IN TOUCHPAD, KEVXY = SDEFCOORDS+MOUSEDRAGXY

  
  //AFTER MOUSE IS TAKEN OFF TOUCHPAD, CARRY ON FROM PREVIOUS COORDINATES WHERE IT LEFT OFF
  // MAKE IT CARRY ON FROM DEFCOORDS.
  //WHERE IT LEFT OFF IS STORED IN DEFCOORDS
  //KNOW THAT MOUSE WAS TAKEN OFF, 
  //MOUSE ISNT IN TOUCHPAD BUT IS IN TOUCHPAD NOW
  //KNOW MOUSE WAS TAKEN OFF AND PUT BACK ON 
    //MOUSE ISNT IN TOUCHPAD BUT IS IN TOUCHPAD NOW
    //defcoords may exist whenever tp =1 
    //what means that the touchpad had been accessed, but is dormant until its accessed again?
    //maybe make so if pmouse was anything outside of the box, start at defcoords?
    //(pmouseX<TPX||pmouseX>TPX+TPH||pmouseY>TPX+TPH||pmouseY<TPX)
    
    //
    
/*
  //IF DEFCOORDS EXIST AND FINGER IS ON THE TOUCHPAD PUT KEV TO DEFCOORD COORDS+MOUSEDRAG!
  File mdefcoords = new File(sketchPath("defcoords.txt"));
  if(defcoords.exists()&&(!(((mouseX > ( TPX+TPH))||(mouseY > (TPY+TPH)))||((mouseX < TPX)||(mouseY < TPY))))){
reader = createReader("defcoords.txt");
  try {
    defcoordshelp = reader.readLine();
  } catch (IOException e) {
    e.printStackTrace();
    defcoordshelp = null;
  }
  if (defcoordshelp == null) {
    // Stop reading because of an error or file is empty
    noLoop();  
  } else {
    String[] pieces = split(defcoordshelp, TAB);
    int x = int(pieces[0]);
    int y = int(pieces[1]);
    image(kev,x+mouseDragX, y+mouseDragY);
  }
  }*/
  
  //MAKE IT THEIR LAST X + 1, LAST Y+1  & WHEN MOUSE X IS MOVED LEFT BY 100 PX, MOVE THEIR LAST X LEFT BY 
  
  
  //MY MOUSE MOVES LEFT 1 PX
  //MOUSE IS AT 900X
  //CHAR IS AT 740X
  //I WANT CHAR WHERE IT IS CURRENTLY TO NOW MOVE LEFT BY 1 
  //I WANT CHAR AT 739X
  //WHEN MOUSE X IS AT 900 AND TURNS TO 899
  //TURN CHAR TO 739
  
  //CHAR 
  
  //EVERY TIME THEY TAKE THEIR FINGER OFF THE TOUCHPAD MAKE A NEW TOUCHPAD
  //EVERY TIME THEY TAKE THEIR FINGER OFF THE TOUCHPAD PUT DEFCOORDS.
  
  
  
  //DRAW NEW TOUCHPAD WHEN THEIR FINGER IS OFF FIRST ONE && HAVE KEVX BE LAST KNOWN COORD
  
  
  
  //DRAWS TOUCHPAD
  
  TPH=displayHeight/5;
  TPX=(displayWidth-TPH-(displayWidth/140));
  TPY=displayHeight/TH+TH+(HBH+(HBH/2));
  
  fill(120);
  stroke(0);  
  strokeWeight(7);
  rect(TPX,TPY,TPH,TPH); 
  

  
  
  
  //DRAWS BACK BUTTON
  /*
  backH=displayHeight/5;
  backX=(displayWidth-TPH-(displayWidth/140));
  backY=displayHeight/TH+TH+(HBH+(HBH/2));
  
  fill(120);
  stroke(0);  
  strokeWeight(7);
  rect(TPX,TPY,TPH,TPH); */
}
}

  
void mousePressed(){
  
  mouseDragX = 0; mouseDragY = 0;  // The drag starts here
  
  //BEGIN BUTTON
  if(!(((mouseX > ( BBX+BBW))||(mouseY > (BBY+BBW)))||((mouseX < BBX)||(mouseY < BBY))))BeginClick=1;
  //HELP BUTTON
  if(!(((mouseX > ( HBX+HBW))||(mouseY > (HBY+HBW)))||((mouseX < HBX)||(mouseY < HBY))))HelpClick=1;
  //TOUCHPAD FOR HELP
  if(!(((mouseX > ( TPX+TPH))||(mouseY > (TPY+TPH)))||((mouseX < TPX)||(mouseY < TPY))))hFirstTouch=1;
  //ALT BUTTON FOR HELP
  
  
  if(ac==0){
  if(!(((mouseX > ( ABX+ABH))||(mouseY > (ABY+ABH)))||((mouseX < ABX)||(mouseY < ABY))))ac=1;
  //MAKE A TEXT FILE TO SAVE A SINGLE DIGIT INSIDE IT
  
}
}

//  if(ac==1&&(!(((mouseX > ( ABX+ABH))||(mouseY > (ABY+ABH)))||((mouseX < ABX)||(mouseY < ABY)))))ac=2;
  


void mouseDragged() {
  if(!(((mouseX > ( TPX+TPH))||(mouseY > (TPY+TPH)))||((mouseX < TPX)||(mouseY < TPY)))){
  mouseDragX += (mouseX - pmouseX);
  mouseDragY += (mouseY - pmouseY);
  }
}

void mouseReleased() {
  // Don't need to really do anything, but at this point, 
  // mouseDragX and mouseDragY should equal the
  // total X and Y distances dragged.
} 

/*
public void mouseDragged(){
  
  
  
  float kevy=displayHeight-(displayHeight/2.5); 
  PImage kev1;
  kev1 = loadImage("kev1.png");
  kev1.resize(displayWidth/5,displayHeight/3);
  int kevw=displayWidth/5;
  int kevh=displayHeight/3;
  
  int OGKevX=displayWidth-(displayWidth/3);
  float OGKevY=displayHeight-(displayHeight/2.5);
    
    if(mouseX>pmouseX){
    kevx=OGKevX+(mouseX-pmouseX);
    }
    if(mouseX<pmouseX){
    kevx=OGKevX-(mouseX-pmouseX);
    }
    if(mouseY>pmouseY){
    kevy=OGKevY+(mouseY-pmouseY);
    }
    if(mouseY<pmouseY){
    kevy=OGKevY-(mouseY-pmouseY);
    }
    image(kev1,kevx,kevy);
    
  
}

// WHEREVER THE XY OF THE DROPLET IS, IF HIT OR KICKED - DEADROPLET, IF STABBED, WHEREVER THE X/Y OF THE TIP OF THE HSWORD WAS, DRAW A [VARWIDTH] TRANSPARENT LINE ACCROSS  THE DROPLET. SAME FOR VSWORD.
//CARRY ON FROM DEFCOORDS AFTER TOUCHPAD IS TOUCHED AGAIN.

//WHEN TOUCHPAD IS TOUCHED AGAIN , KEVY/KEVX = DEFCOORDX, DEFCOORDY + 


/*
  if (BeginClick==1){font
  droplet(rx,ry);
  while(rx < displayWidth && ry < displayHeight){
  if(millis() - time >=wait){
   rx+=100;
   ry+=100;
   droplet(rx,ry); 
  }
}
}
*/
