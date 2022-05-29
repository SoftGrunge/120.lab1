package university;

import java.util.ArrayList;

public class User {
  private int id;
  private String name;
  private boolean isAdmin;
  static ArrayList<Integer> list = new ArrayList<>();

  public User() {
  }

  public boolean isAdmin() {
    return isAdmin;
  }

  public String getName() {
    return name;
  }

  public int getId() {
    return id;
  }


  public User(int id, String name, boolean isAdmin)throws UserException {
    if (list.contains(id)) {
      throw new UserException("ID already exist");
    } else {
      this.id = id;
      list.add(id);
    }
    if (name == null || name.trim().isEmpty()) {
      throw new UserException("Incorrect name");
    } else {
      this.name = name;
    }
    this.isAdmin = isAdmin;
  }

  @Override
  protected Object clone() throws CloneNotSupportedException {
    int newID;
    newID = (int)Math.round(Math.random()*10);
    if(list.contains(newID))
      newID = (int)Math.round(Math.random()*100);
    try{
      return new User(newID,name,isAdmin);
    }catch(UserException ex){
      if(name==null || name.trim().isEmpty())
        throw new CloneNotSupportedException();
    }
    return null;
  }

  @Override
  public boolean equals(Object obj) {
    if(this==obj){
      return true;
    }
    if(obj==null || obj.getClass()!=this.getClass()){
      return false;
    }
    User user = (User)obj;
    return this.name.equals(user.name) && this.isAdmin == user.isAdmin;

  }

  @Override
  public int hashCode() {
    int name = this.name.hashCode();
    int isAdmin =((Boolean)this.isAdmin).hashCode();
    return name+isAdmin;
  }
}