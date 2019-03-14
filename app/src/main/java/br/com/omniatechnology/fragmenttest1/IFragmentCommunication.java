package br.com.omniatechnology.fragmenttest1;

public interface IFragmentCommunication {

    void setUser(User user);

    User getUser();

    void openFragment(int position);

}
