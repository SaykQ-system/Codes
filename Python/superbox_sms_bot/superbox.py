from superboxUserInfo import username, password, cellno, log
from selenium import webdriver
import time

class superbox:
    def __init__(self, username, password, cellno, log):
        self.browser=webdriver.Chrome()
        self.username=username
        self.password=password
        self.cellno=cellno
        self.log=log

    def signIn(self):
        self.browser.get("http://192.168.1.1/index.html#login")
        time.sleep(2)
        username=self.browser.find_element_by_xpath("//*[@id='txtUserName']")
        password=self.browser.find_element_by_xpath("//*[@id='txtPwd']")
        username.send_keys(self.username)
        password.send_keys(self.password)

        time.sleep(1)
        self.browser.find_element_by_xpath("//*[@id='btnLogin']").click()

        time.sleep(1)
        self.browser.get("http://192.168.1.1/index.html#sms")
        
        time.sleep(1)
        self.browser.find_element_by_xpath("//*[@id='smslist-new-sms']").click()

        time.sleep(1)
        self.browser.find_element_by_xpath("//*[@id='chosen-search-field-input']").click()
        cellno=self.browser.find_element_by_xpath("//*[@id='chosen-search-field-input']")
        cellno.send_keys(self.cellno)
        
        time.sleep(1)
        self.browser.find_element_by_xpath("//*[@id='chat-input']").click()
        log=self.browser.find_element_by_xpath("//*[@id='chat-input']")
        log.send_keys(self.log)

        time.sleep(1)
        self.browser.find_element_by_xpath("//*[@id='btn-send']").click()

        time.sleep(3)
        self.browser.close()
        exit()
        
superbox=superbox(username, password, cellno, log)
superbox.signIn()