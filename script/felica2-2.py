#!/usr/bin/env python
# -*- coding: utf-8 -*-
import sys
import binascii
import nfc
import time
from time import sleep

clf = nfc.ContactlessFrontend('usb')
after5s = lambda: time.time() - started > 0.01

def connected(tag):
  print(tag)
  
started = time.time()
clf.connect(rdwr={'on-connect': connected,'terations':1},terminate=after5s)
clf.close

