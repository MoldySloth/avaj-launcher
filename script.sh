find . -name "*.java" > sources.txt
javac -sourcepath . @sources.txt
java avaj.simulator.MainSimulator avaj/scenario.txt