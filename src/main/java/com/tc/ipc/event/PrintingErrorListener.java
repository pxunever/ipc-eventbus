/*
 * Copyright 2015 Terracotta, Inc., a Software AG company.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.tc.ipc.event;

import java.io.PrintStream;

/**
 * @author Mathieu Carbou
 */
public class PrintingErrorListener implements ErrorListener {

  private final PrintStream out;

  public PrintingErrorListener() {
    this(System.err);
  }

  public PrintingErrorListener(PrintStream out) {
    this.out = out;
  }

  @Override
  public void onError(Event event, EventListener listener, Throwable e) {
    out.println("Error in listener " + listener + " for event " + event + ": " + e.getMessage());
    e.printStackTrace(out);
  }
}
