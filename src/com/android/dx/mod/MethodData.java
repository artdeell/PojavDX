package com.android.dx.mod;


public class MethodData {

   public String classCall;
   public Class[] fieldKeys;
   public String[] fieldValues;
   public String methodName;


   public MethodData(String var1) {
      String[] var5 = var1.replace(" ", "").split("->");
      String[] var4 = var5[1].split("\\)")[0].split("\\(");
      String[] var7 = var4[1].split(",");
      this.fieldKeys = new Class[var7.length];
      this.fieldValues = new String[var7.length];
      this.classCall = var5[0];
      this.methodName = var4[0];
      int var3 = 0;

      int var2;
      for(var2 = 0; var2 < var7.length; ++var2) {
         String[] var6 = var7[var2].split(":");
         this.fieldKeys[var3] = this.fromFieldType(var6[1]);
         this.fieldValues[var3] = var6[0];
         System.out.println("SingleField:" + var6[1] + ":" + var6[0]);
         ++var3;
      }

      System.out.println(var5[0] + ":" + var5[1]);

      for(var2 = 0; var2 < var4.length; ++var2) {
         String var9 = var4[var2];
         System.out.println("MethodFields:" + var9);
      }

      for(var2 = 0; var2 < var7.length; ++var2) {
         String var8 = var7[var2];
         System.out.println("Fields:" + var8);
      }

   }

   private Class fromFieldType(String var1) {
      if(var1.equals("String")) {
         try {
            Class var3 = Class.forName("java.lang.String");
            return var3;
         } catch (ClassNotFoundException var2) {
            throw new NoClassDefFoundError(var2.getMessage());
         }
      } else {
         return var1.equals("Integer")?Integer.TYPE:(Class)null;
      }
   }
}
