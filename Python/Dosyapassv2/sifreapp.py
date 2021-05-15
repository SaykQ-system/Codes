from PyQt5 import QtWidgets
import sys
from window import Ui_kilitle
import pyAesCrypt
import os
import time
from PyQt5.QtWidgets import QMessageBox

class App(QtWidgets.QMainWindow):
    def __init__(self):
        super(App,self).__init__()
        self.ui=Ui_kilitle()
        self.ui.setupUi(self)
        self.ui.passbton.clicked.connect(self.islem)
        self.ui.cozbton.clicked.connect(self.islem)
    
    def islem(self):
        sender=self.sender().text()
        bufferSize = 64 * 1024
        if sender=='Şifrele':
            dosya = (self.ui.dosya.text())
            passs = (self.ui.sifre.text())
            pyAesCrypt.encryptFile(dosya, dosya+".aes", passs, bufferSize)
            time.sleep(1)
            msg = QMessageBox()
            msg.setWindowTitle("Şifrele")
            msg.setText("Dosya başarıyla Şifrelendi!")
            msg.setIcon(QMessageBox.Information)
            x = msg.exec_()
            os.system("cls")
        elif sender=='ŞifreÇöz':
            dosya = (self.ui.dosya.text())
            passs = (self.ui.sifre.text())
            uzanti = dosya[:-4]
            pyAesCrypt.decryptFile(dosya, "out"+uzanti, passs, bufferSize)
            time.sleep(1)
            msg = QMessageBox()
            msg.setWindowTitle("Şifrele")
            msg.setText("Dosya başarıyla (decrypt) edildi!")
            msg.setIcon(QMessageBox.Information)
            x = msg.exec_()
            os.system("cls")

def app():
    app=QtWidgets.QApplication(sys.argv)
    win=App()
    win.show()
    sys.exit(app.exec_())

app()