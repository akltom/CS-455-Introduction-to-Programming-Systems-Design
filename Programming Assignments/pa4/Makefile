# Makefile for cs 455 PA4 
#
# you shouldn't need to change anything in the file unless you
# want to submit additional files.
#
#-----------------------------------------------------------------------
#  Unix commands you can use when this file is in the current directory:
#
#     gmake getfiles
#        Copies and/or links data files and this Makefile to current directory.
#
#     gmake submit
#        Submits the assignment.
#
#-----------------------------------------------------------------------
#
# Variable definitions:

HOME = /home/scf-06/csci455
ASSGTS = $(HOME)/assgts
ASSGTDIR = $(ASSGTS)/pa4

#-----------------------------------------------------------------------

getfiles:
	-$(ASSGTS)/bin/safecopy $(ASSGTDIR)/Makefile .
	-$(ASSGTS)/bin/safecopy $(ASSGTDIR)/README .
	-ln -s $(ASSGTDIR)/data/aliceInWonderland.txt .
	-ln -s $(ASSGTDIR)/data/aChristmasCarol.txt .
	-$(ASSGTS)/bin/safecopy $(ASSGTDIR)/data/bluedog .
	-$(ASSGTS)/bin/safecopy $(ASSGTDIR)/data/in1 .
	-$(ASSGTS)/bin/safecopy $(ASSGTDIR)/data/allsame .
	-$(ASSGTS)/bin/safecopy $(ASSGTDIR)/data/empty .
	-$(ASSGTS)/bin/safecopy $(ASSGTDIR)/data/twowords .
	-$(ASSGTS)/bin/safecopy $(ASSGTDIR)/data/integrity .

#-----------------------------------------------------------------------
# you will need to change the submit rule if you want to submit
# additional files.

submit:
	submit -user csci455 -tag pa4 README GenText.java Prefix.java RandomTextGenerator.java

