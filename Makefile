MAIN = NoJavaSky

SRCS = $(wildcard *.java)

all:
	javac $(SRCS)


run: all
	java $(MAIN)

clean:
	rm -f *.class