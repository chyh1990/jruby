/*
 * Copyright (c) 2013, 2016 Oracle and/or its affiliates. All rights reserved. This
 * code is released under a tri EPL/GPL/LGPL license. You can use it,
 * redistribute it and/or modify it under the terms of the:
 *
 * Eclipse Public License version 1.0
 * GNU General Public License version 2
 * GNU Lesser General Public License version 2.1
 */
package org.jruby.truffle.interop;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.interop.AcceptMessage;
import com.oracle.truffle.api.object.DynamicObject;
import org.jruby.truffle.RubyLanguage;
import org.jruby.truffle.language.RubyGuards;
import org.jruby.truffle.language.RubyObjectType;

@AcceptMessage(value = "HAS_SIZE", receiverType = RubyObjectType.class, language = RubyLanguage.class)
public final class ForeignHasSizeNode extends ForeignHasSizeBaseNode {

    @Override
    public Object access(VirtualFrame frame, DynamicObject object) {
        return RubyGuards.isRubyArray(object) || RubyGuards.isRubyHash(object) || RubyGuards.isRubyString(object);
    }

}
