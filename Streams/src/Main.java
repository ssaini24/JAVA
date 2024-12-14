import streams.StreamIntermediateOps;
import streams.StreamTerminalOps;
import streams.StreamVsParallelStream;
import streams.Streams;
import streamsquestions.StreamQuestions;

public class Main {

  public static void main(String[] args) {
    Streams.createStreams();
    StreamIntermediateOps.ops();
    StreamTerminalOps.ops();
    StreamVsParallelStream.vs();

    System.out.println("###### Stream Questions #########");
    StreamQuestions.maxLengthString();
    StreamQuestions.mergeTwoSortedLists();
    StreamQuestions.intersectionTwoList();
    StreamQuestions.sumOfTransactionsOnEachDay();
    StreamQuestions.kthSmallestElement();
    StreamQuestions.freqOfEachWord();
    StreamQuestions.partitionTwoList();
    StreamQuestions.findTotalLengthCovered();
    StreamQuestions.findTotalOccurrence();
    StreamQuestions.printSingleOccurrenceCharsString();
    StreamQuestions.pairsSumUpToTarget();
    StreamQuestions.findNonDuplicateNumbers();
    StreamQuestions.findLongestString();
  }
}