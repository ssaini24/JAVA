import streams.StreamIntermediateOps;
import streams.StreamTerminalOps;
import streams.StreamVsParallelStream;

public class Main {

  public static void main(String[] args) {
    StreamIntermediateOps.ops();
    StreamTerminalOps.ops();
    StreamVsParallelStream.vs();
  }
}