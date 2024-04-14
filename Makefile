compile :
	javac src/academic/model/*.java src/academic/drive/*.java src/academic/controller/*.java -d bin

test_01 :
	cd bin && java academic.drive.Driver1
