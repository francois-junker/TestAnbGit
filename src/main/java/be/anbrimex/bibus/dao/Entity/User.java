/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.anbrimex.bibus.dao.Entity;

/**
 *
 * @author rudy
 */
public class User {

    private int User;
    private int Active;
    private String Nom;
    private int Part1;
    private int Part2;
    private int Part3;
    private int Part4;
    private int Part5;
    private int Part6;
    private int Part7;
    private int Part8;
    private int Attribut;
    private int MAttribut;
    private String Password;
    private int Up_Dl_Nr;
    private int KeyboardAccess;
    private int Twr;
    private int Trd;

    private int[] PartArr = new int[8];

    public User() {

    }

    public User(int User, int Active, String Nom, int Part1, int Part2, int Part3, int Part4, int Part5, int Part6, int Part7, int Part8, int Attribut, int MAttribut, String Password, int Up_Dl_Nr, int KeyboardAccess, int Twr, int Trd) {
        this.User = User;
        this.Active = Active;
        this.Nom = Nom;
        this.Part1 = Part1;
        this.Part2 = Part2;
        this.Part3 = Part3;
        this.Part4 = Part4;
        this.Part5 = Part5;
        this.Part6 = Part6;
        this.Part7 = Part7;
        this.Part8 = Part8;
        this.Attribut = Attribut;
        this.MAttribut = MAttribut;
        this.Password = Password;
        this.Up_Dl_Nr = Up_Dl_Nr;
        this.KeyboardAccess = KeyboardAccess;
        this.Twr = Twr;
        this.Trd = Trd;
        PartArr[0] = this.Part1;
        PartArr[1] = this.Part2;
        PartArr[2] = this.Part3;
        PartArr[3] = this.Part4;
        PartArr[4] = this.Part5;
        PartArr[5] = this.Part6;
        PartArr[6] = this.Part7;
        PartArr[7] = this.Part8;
    }

    /**
     * @return the User
     */
    public int getUser() {
        return User;
    }

    /**
     * @param User the User to set
     */
    public void setUser(int User) {
        this.User = User;
    }

    /**
     * @return the Active
     */
    public int getActive() {
        return Active;
    }

    /**
     * @param Active the Active to set
     */
    public void setActive(int Active) {
        this.Active = Active;
    }

    /**
     * @return the Nom
     */
    public String getNom() {
        return Nom;
    }

    /**
     * @param Nom the Nom to set
     */
    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    /**
     * @return the Part1
     */
    public int getPart1() {
        return Part1;
    }

    /**
     * @param Part1 the Part1 to set
     */
    public void setPart1(int Part1) {
        this.Part1 = Part1;
    }

    /**
     * @return the Part2
     */
    public int getPart2() {
        return Part2;
    }

    /**
     * @param Part2 the Part2 to set
     */
    public void setPart2(int Part2) {
        this.Part2 = Part2;
    }

    /**
     * @return the Part3
     */
    public int getPart3() {
        return Part3;
    }

    /**
     * @param Part3 the Part3 to set
     */
    public void setPart3(int Part3) {
        this.Part3 = Part3;
    }

    /**
     * @return the Part4
     */
    public int getPart4() {
        return Part4;
    }

    /**
     * @param Part4 the Part4 to set
     */
    public void setPart4(int Part4) {
        this.Part4 = Part4;
    }

    /**
     * @return the Part5
     */
    public int getPart5() {
        return Part5;
    }

    /**
     * @param Part5 the Part5 to set
     */
    public void setPart5(int Part5) {
        this.Part5 = Part5;
    }

    /**
     * @return the Part6
     */
    public int getPart6() {
        return Part6;
    }

    /**
     * @param Part6 the Part6 to set
     */
    public void setPart6(int Part6) {
        this.Part6 = Part6;
    }

    /**
     * @return the Part7
     */
    public int getPart7() {
        return Part7;
    }

    /**
     * @param Part7 the Part7 to set
     */
    public void setPart7(int Part7) {
        this.Part7 = Part7;
    }

    /**
     * @return the Part8
     */
    public int getPart8() {
        return Part8;
    }

    /**
     * @param Part8 the Part8 to set
     */
    public void setPart8(int Part8) {
        this.Part8 = Part8;
    }

    /**
     * @return the Attribut
     */
    public int getAttribut() {
        return Attribut;
    }

    /**
     * @param Attribut the Attribut to set
     */
    public void setAttribut(int Attribut) {
        this.Attribut = Attribut;
    }

    /**
     * @return the MAttribut
     */
    public int getMAttribut() {
        return MAttribut;
    }

    /**
     * @param MAttribut the MAttribut to set
     */
    public void setMAttribut(int MAttribut) {
        this.MAttribut = MAttribut;
    }

    /**
     * @return the Password
     */
    public String getPassword() {
        return Password;
    }

    /**
     * @param Password the Password to set
     */
    public void setPassword(String Password) {
        this.Password = Password;
    }

    /**
     * @return the Up_Dl_Nr
     */
    public int getUp_Dl_Nr() {
        return Up_Dl_Nr;
    }

    /**
     * @param Up_Dl_Nr the Up_Dl_Nr to set
     */
    public void setUp_Dl_Nr(int Up_Dl_Nr) {
        this.Up_Dl_Nr = Up_Dl_Nr;
    }

    /**
     * @return the KeyboardAccess
     */
    public int getKeyboardAccess() {
        return KeyboardAccess;
    }

    /**
     * @param KeyboardAccess the KeyboardAccess to set
     */
    public void setKeyboardAccess(int KeyboardAccess) {
        this.KeyboardAccess = KeyboardAccess;
    }

    /**
     * @return the Twr
     */
    public int getTwr() {
        return Twr;
    }

    /**
     * @param Twr the Twr to set
     */
    public void setTwr(int Twr) {
        this.Twr = Twr;
    }

    /**
     * @return the Trd
     */
    public int getTrd() {
        return Trd;
    }

    /**
     * @param Trd the Trd to set
     */
    public void setTrd(int Trd) {
        this.Trd = Trd;
    }

    /**
     * @return the PartArr
     */
    public int[] getPartArr() {
        return PartArr;
    }

    /**
     * @param PartArr the PartArr to set
     */
    public void setPartArr(int[] PartArr) {
        this.PartArr = PartArr;
    }

}
