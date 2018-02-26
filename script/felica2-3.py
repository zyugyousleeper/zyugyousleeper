#!/usr/bin/env python
import sys
import binascii
import nfc
import time
import re
from time import sleep

clf = nfc.ContactlessFrontend('usb')
after5s = lambda: time.time() - started > 0.01

def connected(tag):
  id = str(tag)
  matchObj = re.search('ID=.+?\ ',id)
  print(matchObj.group()[3:])
  
started = time.time()
clf.connect(rdwr={'on-connect': connected,'terations':1},terminate=after5s)
clf.close

