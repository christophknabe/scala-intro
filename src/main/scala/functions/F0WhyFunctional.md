2022-06-08 Christoph Knabe
# Why Functional Programming helps Parallel/Asynchronous Processing?
* Since 2003 the processor frequency does not grow due to physical limits.<br>
  See the article
  [The free lunch is over](http://www.gotw.ca/publications/concurrency-ddj.htm)
  by Herb Sutter. Look at the graph.
* But processors get more cores which work in parallel.
* &rArr; If we do not use the cores in parallel, we throw away much of processing power.
* The hardest thing in parallel, as well as in asynchronous programming is shared state.
* If e.g. 2 threads have common state, they have to synchronize about it.

## Approaches to Parallel or Asynchronous Programming
* **Threads** like in Java, with **synchronized** blocks
* **Actors** like in Erlang (async message sending, sequential processing of inbox messages)
* **Future** as a kind of organized callback.
* Pure **Functional Programming** à la Haskell. Completely avoid state.

## Functional Style avoids State
* A mathematical function does not have state.
* The result only depends on the arguments.
* &rArr; The result does not depend on time (what executed first).

We will treat functional programming only in memory, 
not in communication with outside world.