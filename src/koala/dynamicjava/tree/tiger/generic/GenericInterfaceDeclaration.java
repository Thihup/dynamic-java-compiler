/*BEGIN_COPYRIGHT_BLOCK
 *
 * This file is part of DrJava.  Download the current version of this project:
 * http://sourceforge.net/projects/drjava/ or http://www.drjava.org/
 *
 * DrJava Open Source License
 *
 * Copyright (C) 2001-2003 JavaPLT group at Rice University (javaplt@rice.edu)
 * All rights reserved.
 *
 * Developed by:   Java Programming Languages Team
 *                 Rice University
 *                 http://www.cs.rice.edu/~javaplt/
 *
 * Permission is hereby granted, free of charge, to any person obtaining a
 * copy of this software and associated documentation files (the "Software"),
 * to deal with the Software without restriction, including without
 * limitation the rights to use, copy, modify, merge, publish, distribute,
 * sublicense, and/or sell copies of the Software, and to permit persons to
 * whom the Software is furnished to do so, subject to the following
 * conditions:
 *
 *     - Redistributions of source code must retain the above copyright
 *       notice, this list of conditions and the following disclaimers.
 *     - Redistributions in binary form must reproduce the above copyright
 *       notice, this list of conditions and the following disclaimers in the
 *       documentation and/or other materials provided with the distribution.
 *     - Neither the names of DrJava, the JavaPLT, Rice University, nor the
 *       names of its contributors may be used to endorse or promote products
 *       derived from this Software without specific prior written permission.
 *     - Products derived from this software may not be called "DrJava" nor
 *       use the term "DrJava" as part of their names without prior written
 *       permission from the JavaPLT group.  For permission, write to
 *       javaplt@rice.edu.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL
 * THE CONTRIBUTORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR
 * OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE,
 * ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
 * OTHER DEALINGS WITH THE SOFTWARE.
 *
 END_COPYRIGHT_BLOCK*/

package koala.dynamicjava.tree.tiger.generic;


import koala.dynamicjava.tree.*;

import java.util.List;

/**
 * This class represents a generic class declaration
 */

public class GenericInterfaceDeclaration extends InterfaceDeclaration {
  
  private TypeParameter[] _typeParameters;
  
  /**
   * Creates a new class declaration
   * @param flags the access flags
   * @param name  the name of the class to declare
   * @param impl  the list of implemented interfaces (List of List of Token). Can be null.
   * @param body  the list of fields declarations
   * @param typeParams the type parameters
   * @exception IllegalArgumentException if name is null or body is null
   */
  public GenericInterfaceDeclaration(int flags, String name, List<? extends ReferenceTypeName> impl, List<Node> body, TypeParameter[] typeParams) {
    this(flags, name, impl, body, null, 0, 0, 0, 0, typeParams);
  }
  
  /**
   * Creates a new class declaration
   * @param flags      the access flags
   * @param name       the name of the class to declare
   * @param impl       the list of implemented interfaces (a list of list of Token). Can be null.
   * @param body       the list of members declarations
   * @param fn         the filename
   * @param bl         the begin line
   * @param bc         the begin column
   * @param el         the end line
   * @param ec         the end column
   * @param typeParams the type parameters
   * @exception IllegalArgumentException if name is null or body is null
   */
  public GenericInterfaceDeclaration(int flags, String name, List<? extends ReferenceTypeName> impl, List<Node> body,
                                     String fn, int bl, int bc, int el, int ec, TypeParameter[] typeParams) {
    super(flags, name, impl, body, fn, bl, bc, el, ec);
    _typeParameters = typeParams;
  }
  
  public TypeParameter[] getTypeParameters(){ return _typeParameters; }
  
  public String toString() {
    return "("+getClass().getName()+": "+toStringHelper()+")";
  }
  
  protected String toStringHelper(){
    TypeParameter[] tp = getTypeParameters();
    String typeParamsS = "";
    if(tp.length>0)
      typeParamsS = ""+tp[0];
    for(int i = 1; i < tp.length; i++)
      typeParamsS = typeParamsS + " " + tp[i];
    
    return typeParamsS+" "+super.toStringHelper();
  }
}