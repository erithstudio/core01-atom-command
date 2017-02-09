/**
 * Copyright 2017, Denis Prasetio, Erith Studio
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License
 * at http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.erith.core.atomcommand.components.variables;

/// <summary>
/// Generic concrete base class for variables.
/// </summary>
public abstract class VariableBase<T> extends Variable {
    protected T value;
    protected T startValue;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public void onReset() {
        value = startValue;
    }

    protected void start() {
        // Remember the initial value so we can reset later on
        startValue = value;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}