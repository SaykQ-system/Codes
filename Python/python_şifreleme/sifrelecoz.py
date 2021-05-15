import pyAesCrypt
import os
import time

bufferSize = 64 * 1024
print("1 < Şifreleme")
print("2 < Çözme")
islem=input("SEÇİM:")

if islem=="1":
    dosya = input("Şifrelençek Dosya: ")
    passs = input("Not: Şifreyi unutma yoksa ağlarsın! Şifre : ")
    pyAesCrypt.encryptFile(dosya, dosya+".aes", passs, bufferSize)
    print("Tamamlandı !")
    time.sleep(1)
    #os.system("cls")

elif islem=="2":
    dosya = input("Çözülecek Dosya: ")
    passs = input("Şifreyi bilmiyorsan geçmiş olsun! Şifre : ")
    uzanti = dosya[:-4]
    pyAesCrypt.decryptFile(dosya, "out"+uzanti, passs, bufferSize)
    print("Complete !")
    time.sleep(1)
    #os.system("cls")