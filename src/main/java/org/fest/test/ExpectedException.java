/*
 * Created on Sep 7, 2010
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 *
 * Copyright @2010-2013 the original author or authors.
 */
package org.fest.test;

import javax.annotation.Nonnull;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

/**
 * Allows in-test specification of expected exception types and messages.
 *
 * @author Alex Ruiz
 */
public class ExpectedException implements TestRule {
  private final org.junit.rules.ExpectedException delegate = org.junit.rules.ExpectedException.none();

  public static ExpectedException none() {
    return new ExpectedException();
  }

  private ExpectedException() {}

  @Override
  public Statement apply(Statement base, Description description) {
    return delegate.apply(base, description);
  }

  public void expect(@Nonnull Class<? extends Throwable> type, @Nonnull String message) {
    expect(type);
    expectMessage(message);
  }

  public void expect(@Nonnull Class<? extends Throwable> type) {
    delegate.expect(type);
  }

  public void expectMessage(@Nonnull String message) {
    delegate.expectMessage(message);
  }
}
