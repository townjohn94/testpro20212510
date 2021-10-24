package auth;

import static org.junit.Assert.*;

import org.junit.Test;

import AbsMine.Steklo;
public class TestAbstr {

@Test //Тест абстрактного класса
public void test() {
Steklo kark= new Steklo();
String N= "name";
kark.setName("name");
String N1= kark.getName();

assertEquals(N, N1); //Проверка на нулевое значение метода
}

}